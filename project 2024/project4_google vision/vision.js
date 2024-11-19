// Google Vision API 키와
VISION_API_KEY = "AIzaSyAJrBx6424d5aTpQN6GGHS_9zrMaY0raFE";

let imagestring ='';

// 파일을 업로드하는 함수
function uploadFiles(files){
    file = files[0];
    reader = new FileReader();
    reader.onloadend = processFile;
    reader.readAsDataURL(file);
}

//파일을 처리하고 이미지를 표시하는 함수
function processFile(event){
    content = event.target.result;
    imagestring = content.replace('data:image/jpeg;base64,', '');
    document.getElementById("gimage").src = content;
}

// 로딩 애니메이션,파일이 없으면 경고창 표시 후 종료
function analyzeWithAnimation() {
    var analyzeBtn = document.getElementById('analyzeBtn');
    var loadingSpinner = document.getElementById('loadingSpinner');
    var image = document.getElementById('gimage');

    // 이미지 파일이 없으면 경고창 표시 후 종료
    if (!imagestring) {
        alert("이미지 파일이 없습니다.");
        return;
    }

    //애니메이션
    analyzeBtn.classList.add('loading');
    analyzeBtn.value = '분석 중...';
    loadingSpinner.style.display = 'block'; // 스피너 표시
    image.classList.add('loading'); // 이미지 반투명화

    // 실제 분석 함수 호출
    analyze();

    // 일정 시간 후 애니메이션 종료
    setTimeout(function() {
        analyzeBtn.classList.remove('loading');
        analyzeBtn.value = '이미지 분석';
        loadingSpinner.style.display = 'none'; // 스피너 숨기기
        image.classList.remove('loading'); // 이미지 원래 상태로 복구
    }, 2000);
}

function analyze(){
    let data = {
        requests: [{
            image: {
                content: imagestring
            },
            features: [{
                type: "FACE_DETECTION",
                maxResults: 40 //최대 얼굴 인식 수
            }]
        }]
    };

    $.ajax({
        type: "POST",
        url: 'https://vision.googleapis.com/v1/images:annotate?key=' + VISION_API_KEY,
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8"
    }).done(function(response) {
        let faceAnnotations = response.responses[0].faceAnnotations;

        drawBoundingBoxes(faceAnnotations);
        let resultText = '';
        faceAnnotations.forEach((face, index) => {
            let anger = face.angerLikelihood;
            let joy = face.joyLikelihood;
            let sorrow = face.sorrowLikelihood;
            let surprise = face.surpriseLikelihood;
            let headwear = face.headwearLikelihood;

            resultText += `얼굴 ${index + 1}:\n`;
            resultText += `${convertLikelihood('anger', anger)}\n`;
            resultText += `${convertLikelihood('joy', joy)}\n`;
            resultText += `${convertLikelihood('sorrow', sorrow)}\n`;
            resultText += `${convertLikelihood('surprise', surprise)}\n`;
            resultText += `${convertLikelihood('headwear', headwear)}\n\n`;
        });

        

        document.getElementById('result').value = resultText;

    }).fail(function(error) {
        console.log(error);
        alert("이미지 분석 중 오류가 발생했습니다. 다시 시도해주세요.");
    });
}

function drawBoundingBoxes(faceAnnotations) {
    let canvas = document.getElementById('faceCanvas');
    let img = document.getElementById('gimage');
    let context = canvas.getContext('2d');

    // 이미지가 로드되었는지 확인
    if (!img.complete) {
        img.onload = function() {
            drawBoxes();
        };
    } else {
        drawBoxes();
    }

    function drawBoxes() {
        // 캔버스 크기를 이미지의 실제 표시 크기와 동일하게 설정
        canvas.width = img.clientWidth;
        canvas.height = img.clientHeight;

        context.clearRect(0, 0, canvas.width, canvas.height);
        context.strokeStyle = 'rgba(73, 197, 228, 0.8)'
        context.lineWidth = 2;

        // 이미지와 캔버스의 비율 계산
        const scaleX = canvas.width / img.naturalWidth;
        const scaleY = canvas.height / img.naturalHeight;

        faceAnnotations.forEach((face, index) => {
            let vertices = face.boundingPoly.vertices;
            
            // 좌표를 현재 표시 크기에 맞게 조정
            let x = vertices[0].x * scaleX;
            let y = vertices[0].y * scaleY;
            let width = (vertices[1].x - vertices[0].x) * scaleX;
            let height = (vertices[2].y - vertices[0].y) * scaleY;

            // 바운딩 박스 그리기
            context.strokeRect(x, y, width, height);

            // 라벨링 추가
            context.font = '14px Arial';
            context.fillStyle = 'rgba(73, 197, 228, 1.0)';
            context.fillText(`얼굴 ${index + 1}`, x, y - 5);
        });
    }
}

//
function convertLikelihood(emotion, value) {
    if (emotion === 'anger') {
        if (value === "VERY_UNLIKELY") return "    화난 것 같진 않네요.";
        if (value === "VERY_LIKELY") return "    화가 많이 나 있는 것 같아요.";
    }
    if (emotion === 'joy') {
        if (value === "VERY_UNLIKELY") return "    기쁜 기색은 보이지 않네요.";
        if (value === "VERY_LIKELY") return "    기쁨이 느껴지네요!";
    }
    if (emotion === 'sorrow') {
        if (value === "VERY_UNLIKELY") return "    슬퍼 보이진 않아요.";
        if (value === "VERY_LIKELY") return "    슬픔이 가득한 표정이네요.";
    }
    if (emotion === 'surprise') {
        if (value === "VERY_UNLIKELY") return "    놀란 표정은 아니네요.";
        if (value === "VERY_LIKELY") return "    많이 놀란 것 같아요!";
    }
    if (emotion === 'headwear') {
        if (value === "VERY_UNLIKELY") return "    머리 장식은 없는 것 같아요.";
        if (value === "VERY_LIKELY") return "    머리 장식을 하고 있네요.";
    }
    return "    감정 상태를 파악하기 어려워요.";
}
