package com.example.planpro;

import com.example.planpro.project.ViewProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.example.planpro.TestUtils.withRecyclerView;

@RunWith(AndroidJUnit4.class)
public class ViewProjectTest {

    @Rule
    public ActivityTestRule<ViewProject> activityTestRule = new ActivityTestRule<ViewProject>(ViewProject.class);
    private ViewProject viewProject = null;

    @Before
    public void setUp() throws Exception {
        viewProject = activityTestRule.getActivity();
//add tiemr
        //Mack sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(5000 * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(5000 * 2, TimeUnit.MILLISECONDS);
        //Now we waite
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(5000);
        try {
            IdlingRegistry.getInstance().register(idlingResource);
            //check the activity visible
            onView(withId(R.id.ViewProject)).check(matches(isDisplayed()));
            //check text views visible
            //description
            onView(withId(R.id.description)).check(matches(isDisplayed()));
            //date
            //onView(withId(R.id.startDate)).check(matches(isDisplayed()));
            //onView(withId(R.id.endDate)).check(matches(isDisplayed()));
            //cost
            onView(withId(R.id.totalCost)).check(matches(isDisplayed()));
            //check the add button visible
            onView(withId(R.id.fab)).check(matches(isDisplayed()));
            //delete project
            onView(withId(R.id.Delete)).check(matches(isDisplayed()));
        }
        //clean upp
        finally {
            IdlingRegistry.getInstance().unregister(idlingResource);
        }
    }

    //TODO check for recycler view
    @Test
    public void testItemClick() {

        onView(withRecyclerView(R.id.tasksRecyclerView).atPosition(1)).perform(click());
        //add tiemr
        //Mack sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(5000 * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(5000 * 2, TimeUnit.MILLISECONDS);
        //Now we waite
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(5000);
        try {
            IdlingRegistry.getInstance().register(idlingResource);
            //activity
            onView(withId(R.id.ViewTask)).check(matches(isDisplayed()));
            //task name
            onView(withId(R.id.textView2)).check(matches(isDisplayed()));
            //res
            onView(withId(R.id.Resources)).check(matches(isDisplayed()));
            //cost
            onView(withId(R.id.TaskCost)).check(matches(isDisplayed()));
            //buttons
            onView(withId(R.id.DeleteT)).check(matches(isDisplayed()));
        }
        //clean upp
        finally {
            IdlingRegistry.getInstance().unregister(idlingResource);
        }
    }

    @Test
    public void AddTask () {
        //check when click on add button
        onView(withId(R.id.fab)).perform(click());
        //the add task page appear
        onView(withId(R.id.AddTask)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        viewProject = null;
    }
}