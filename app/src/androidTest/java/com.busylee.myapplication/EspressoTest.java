package com.busylee.myapplication;

import androidx.annotation.Nullable;
import androidx.test.filters.LargeTest;

import org.junit.Test;

import androidx.test.core.app.ActivityScenario;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;


@LargeTest
public class EspressoTest {
    int btnAction = R.id.btn_action;
    int etText = R.id.et_text;
    int tvText = R.id.tv_text;
    String text1 = "Hello_world";
    String text2 = "12345";
    String text3 = "Open fire";
    String text4 = "hellohellohellohellohellohellohello";


    private void typeIntoEditText(@Nullable String text) {
        try (ActivityScenario scenario = ActivityScenario.launch(MainActivity.class)) {
            onView(withId(etText)).perform(click(), typeText(text));                // click form + type text
            onView(withId(etText)).check(matches(withText(containsString(text))));        // search text in view
            onView(withId(btnAction)).perform(click());                                             // click on action button
            onView(withId(tvText)).check(matches(withText(containsString(text))));   // search element is screen
        }
    }

    @Test
    public void type_text_in_form() {
        typeIntoEditText(text1);
    }

    @Test
    public void type_figures_in_form() {
        typeIntoEditText(text2);
    }

    @Test
    public void type_text_in_form_with_space() {
        typeIntoEditText(" ");
    }

    @Test
    public void type_some_words() {
        typeIntoEditText(text3);
    }

    @Test
    public void type_long_word() {
        typeIntoEditText(text4);
    }
}
