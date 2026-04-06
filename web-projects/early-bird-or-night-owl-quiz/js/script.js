const quizData = [
  {
    question: "What type of worker best describes you?",
    options: [
      { text: "Procrastinator", type: "night" },
      { text: "Go-Getter", type: "early" },
    ],
  },
  {
    question: "What type of breakfast would you eat?",
    options: [
      { text: "Heavy Breakfast", type: "early" },
      { text: "Light Breakfast", type: "night" },
    ],
  },
  {
    question: "How would you rather spend your time?",
    options: [
      { text: "Going Out", type: "night" },
      { text: "Staying Inside", type: "early" },
    ],
  },
  {
    question: "When is your energy highest?",
    options: [
      { text: "Morning", type: "early" },
      { text: "Night", type: "night" },
    ],
  },
  {
    question: "When do you prefer to sleep?",
    options: [
      { text: "Early to Bed", type: "early" },
      { text: "Late to Bed", type: "night" },
    ],
  },
  {
    question: "What's your productivity style?",
    options: [
      { text: "Checklists & schedules", type: "early" },
      { text: "Spur-of-the-moment creativity", type: "night" },
    ],
  },
];

let currentQuestion = 0;
let score = { early: 0, night: 0 };

const questionBox = document.getElementById("question-box");
const progressBar = document.getElementById("progress-bar");
const resultDiv = document.getElementById("result");
const restartBtn = document.getElementById("restart-btn");

function loadQuestion() {
  if (currentQuestion >= quizData.length) {
    showResult();
    return;
  }

  const q = quizData[currentQuestion];
  questionBox.innerHTML = `<h2>${q.question}</h2>
<div class="options">
${q.options
  .map(
    (opt, idx) => `
  <div class="option-card" data-type="${opt.type}">
    <p>${opt.text}</p>
  </div>
`,
  )
  .join("")}
</div>
`;

  const optionCards = document.querySelectorAll(".option-card");
  optionCards.forEach((card) => {
    card.addEventListener("click", () => {
      const type = card.dataset.type;
      score[type]++;
      currentQuestion++;
      updateProgress();
      loadQuestion();
    });
  });
}

function updateProgress() {
  const percent = (currentQuestion / quizData.length) * 100;
  progressBar.style.width = percent + "%";
}

function showResult() {
  questionBox.style.display = "none";
  resultDiv.style.display = "block";
  restartBtn.style.display = "inline-block";
  if (score.early > score.night) {
    resultDiv.textContent = "You are an Early Bird! 🌅";
  } else if (score.night > score.early) {
    resultDiv.textContent = "You are a Night Owl! 🌙";
  } else {
    resultDiv.textContent =
      "You're balanced between Early Bird and Night Owl! 🌞🌜";
  }
}

restartBtn.addEventListener("click", () => {
  currentQuestion = 0;
  score = { early: 0, night: 0 };
  questionBox.style.display = "block";
  resultDiv.style.display = "none";
  restartBtn.style.display = "none";
  updateProgress();
  loadQuestion();
});

loadQuestion();
