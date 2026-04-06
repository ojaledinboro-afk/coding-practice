//BMI calculator

/*  
    Metric System: weight(kg)/height(m)^2
    U.S. Customary System: weight(lbs)/height(in)^2 x 703
*/

//Inputs /Elements
const heightInput = document.getElementById("heightInput");
const weightInput = document.getElementById("weightInput");
const button = document.getElementById("calculateButton");
const output = document.getElementById("output");
const outputContainer = document.querySelector(".output-container");

const metricBtn = document.getElementById("metricBtn");
const usBtn = document.getElementById("usBtn");
const unitLabel = document.getElementById("unitLabel");

// State
let currentMode = "metric";

//BMI Functions
function metricBMI(weight, height) {
  let bmi = weight / height ** 2;
  //.toFixed rounds decimal by a certain number
  return bmi.toFixed(2);
}

function usBMI(weight, height) {
  let bmi = (weight / height ** 2) * 703;
  return bmi.toFixed(2);
}

// Category Function
function getCategory(bmi) {
  bmi = parseFloat(bmi);
  if (bmi < 18.5) return "Underweight";
  if (bmi < 25) return "Normal";
  if (bmi < 30) return "Overweight";
  return "Obese";
}

// Toggle Buttons
metricBtn.addEventListener("click", () => {
  outputContainer.classList.add("hidden");
  currentMode = "metric";
  unitLabel.textContent = "Metric";

  metricBtn.classList.add("active");
  usBtn.classList.remove("active");

  weightInput.placeholder = "Enter weight (kg)";
  heightInput.placeholder = "Enter height (m)";
});

usBtn.addEventListener("click", () => {
  outputContainer.classList.add("hidden");
  currentMode = "us";
  unitLabel.textContent = "US";

  usBtn.classList.add("active");
  metricBtn.classList.remove("active");

  weightInput.placeholder = "Enter weight (lbs)";
  heightInput.placeholder = "Enter height (in)";
});

// Calculate Button
button.addEventListener("click", function () {
  output.innerHTML = "";

  let height = parseFloat(heightInput.value);
  let weight = parseFloat(weightInput.value);

  // Validation
  if (isNaN(height) || isNaN(weight)) {
    output.innerHTML = "Please enter valid numbers";
    outputContainer.classList.remove("hidden");
    return;
  }

  let result;

  if (currentMode === "metric") {
    result = metricBMI(weight, height);
  } else {
    result = usBMI(weight, height);
  }

  let category = getCategory(result);

  output.innerHTML = `${result} (${category})`;

  outputContainer.classList.remove("hidden");
});

/* 
// Embedding funcs work with consts only appearently
const kg = 70;
const m = 1.75;

console.log(`If you weigh ${kg} kg and are ${m} meters then your BMI is ${metricBMI(kg, m)}`);

const lbs = 150;
const ins = 65;

console.log(`If you weigh ${lbs} lbs and are ${ins} ins then your BMI is ${usBMI(lbs, ins)}`);
*/
