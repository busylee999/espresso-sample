package com.busylee.myapplication;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    private String SIMPLE_TEXT = "test";
    private String TEXT_WITH_SPACE = "test test";
    private String EMPTY = "";

    private void typeTextAndCheck(String text) {
        onView(withId(R.id.et_text)).perform(typeText(text));
        onView(withId(R.id.btn_action)).perform(click());
        onView(withId(R.id.tv_text)).check(matches(withText(text)));
    }

    @Test
    public void testTitleText() {
        /* 1. На Экране №1 отображается заголовок, текст = "Enter a text!"*/
        onView(withId(R.id.first_title)).check(matches(withText("Enter a text!")));
    }

    @Test
    public void testButtonText() {
        /* 2. На Экране №1 есть кнопка, текст кнопки "Open"*/
        onView(withId(R.id.btn_action)).check(matches(withText("Open")));
    }

    @Test
    public void testInputFieldDisplayed() {
        /* 3. На Экране №1 отображается строка для ввода текста */
        onView(withId(R.id.et_text)).check(matches(isDisplayed()));
    }

    @Test
    public void testTextEqual() {
        /* 7. На Экране №2 отображается текст введенный пользователем */
        typeTextAndCheck(SIMPLE_TEXT);
    }

    @Test
    public void testTextWithSpace() {
        /* 11. Проверить ввод строки с пробелами */
        typeTextAndCheck(TEXT_WITH_SPACE);
    }

    @Test
    public void testEmptyInput() {
        /* 10. Проверить пустой ввод */
        typeTextAndCheck(EMPTY);
    }

    @Test
    public void testPressBack() {
        /* 8. С экрана №2 можно вернуться к экрану номер №1 по кнопке "назад". Состояние экрана №1 сохраняется */
        typeTextAndCheck(SIMPLE_TEXT);
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.et_text)).check(matches(withText(SIMPLE_TEXT)));
    }
}
