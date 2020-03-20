package com.busylee.myapplication;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> activityActivityTestRule = new ActivityTestRule<>(SecondActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSecondTitleText() {
        /* На экране №2 отображается заголовок, текст = "Your text:""*/
        onView(withId(R.id.second_title)).check(matches(withText("Your text:")));
    }
}
