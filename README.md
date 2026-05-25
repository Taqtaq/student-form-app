# Student Form Application (Jetpack Compose)

A native Android application built using **Jetpack Compose** that collects student information through a customized user interface with robust input validation. 

This project fulfills all the requirements of **Assignment 2**.

---

## 📱 Features & UI Customization

The application features a unique, custom-styled user interface designed to move away from the standard Material Design look:

* **Custom Input Fields:** Fully customized fields for entering the student's Name and Email Address.
* **Platform Selection:** A custom radio button group to choose between Android, iOS, and Web platforms.
* **Date Picker:** A clickable date field that triggers a native `DatePickerDialog`, formatting the selected date into `DD/MM/YYYY`.
* **Terms Agreement:** A custom toggle switch for accepting the rules and terms.

---

## 🎬 Application Demo

Below is the required video demonstration showing the full workflow of the app:
1. **Authorization:** Filling in the Name field with the developer's full name.
2. **Validation Check:** Pressing the Submit button with empty fields to trigger the validation error Toast.
3. **Interaction:** Clicking the date field, opening the calendar, and selecting a date.
4. **Completion:** Filling out all fields correctly and successfully submitting the form.

![App Demo] https://github.com/user-attachments/assets/7bf9cb9d-abdd-4c66-9db3-9249599586e3



---

## 🛠 State Management Variables

As per the guidelines, the state lifecycle leverages the following explicit naming conventions:
* `nameState` / `emailState` / `dateState` — Handling text inputs.
* `selectedOption` — Tracking the chosen platform.
* `isAgreed` — Storing the boolean state of the terms agreement.

---

## 🛑 Validation Logic

When the **Submit** button is pressed, the application evaluates the current state against three strict criteria:
1. All text fields (`nameState`, `emailState`, `dateState`) must be filled.
2. One option from the platform `RadioButtons` must be selected.
3. The terms agreement `Switch` must be toggled **On**.

**Outcomes:**
* **Validation Failure:** If any condition is unmet, a Toast displays: `"შეავსეთ ყველა ველი!"`
* **Validation Success:** If all conditions pass, a Toast displays: `"მონაცემები გაიგზავნა!"`
