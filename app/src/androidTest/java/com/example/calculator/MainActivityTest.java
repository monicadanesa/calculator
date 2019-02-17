package com.example.calculator;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    TextView totalTextView;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_input_percentage(){
        float percentage = 10;
        float number = 50;

        float result = number*(percentage/100);

        onView(allOf(withId(R.id.percentageEditView)))
                .perform(ViewActions.typeText(Float.toString(percentage)));

        onView(allOf(withId(R.id.numberEditView)))
                .perform(ViewActions.typeText(Float.toString(number)));
        onView(allOf(withId(R.id.btnCalculate)))
                .perform(click());

        onView(allOf(withId(R.id.totalTextView)))
                .check(matches(withText(Float.toString(result))));
    }


}
