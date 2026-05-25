// StudentFormScreen.kt
package com.example.studentformapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentformapp.components.CustomRadioGroup
import com.example.studentformapp.components.CustomSwitch
import com.example.studentformapp.components.CustomTextField
import com.example.studentformapp.components.DatePickerField
import com.example.studentformapp.components.SubmitButton
import com.example.studentformapp.ui.theme.CardBackground
import com.example.studentformapp.ui.theme.DarkBackground
import com.example.studentformapp.ui.theme.TextPrimary

@Composable
fun StudentFormScreen(
    viewModel: StudentFormViewModel = viewModel()
) {
    val formState by viewModel.formState.collectAsState()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(CardBackground)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "სტუდენტის ფორმა",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            CustomTextField(
                value = formState.nameState,
                onValueChange = { viewModel.updateName(it) },
                label = "სახელი"
            )

            CustomTextField(
                value = formState.emailState,
                onValueChange = { viewModel.updateEmail(it) },
                label = "ელ. ფოსტა"
            )

            DatePickerField(
                value = formState.dateState,
                onDateSelected = { viewModel.updateDate(it) },
                label = "დაბადების თარიღი"
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomRadioGroup(
                question = "აირჩიეთ თქვენი ფავორიტი პლატფორმა",
                options = listOf("Android", "iOS", "Web"),
                selectedOption = formState.selectedOption,
                onOptionSelected = { viewModel.updateSelectedOption(it) }
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomSwitch(
                checked = formState.isAgreed,
                onCheckedChange = { viewModel.updateAgreement(it) },
                label = "ვეთანხმები წესებს და პირობებს"
            )

            Spacer(modifier = Modifier.height(12.dp))

            SubmitButton(
                text = "გაგზავნა",
                onClick = {
                    if (viewModel.validateForm()) {
                        Toast.makeText(context, "მონაცემები გაიგზავნა!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "შეავსეთ ყველა ველი!", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}
