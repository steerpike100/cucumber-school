package io.cucumber.shouty;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stepdefsbread {

    private Map<String, Loaf> loaf;

    @Before
    public void createNetwork() {
        loaf = new HashMap<String, Loaf>();
    }
    
    public static class Bread {
        public int flour;
        public int water;
        public int salt;
        public int yeast;
        
    }

    @Given("^the following ingredients:$")
    public void the_following_ingredients(@Transpose List<Bread> bread) throws Throwable {
        for (Bread ingredients : bread) {
            Loaf put = loaf.put(ingredients.flour, ingredients.water, ingredients.salt, ingredients.yeast, new Loaf(ingredients.flour, ingredients.flour, ingredients.salt, ingredients.yeast));
        }
    }


    @When("^I mix the ingredients into a dough And I shape the dough into (\\d+) loaves$")
    public void i_mix_the_ingredients_into_a_dough_And_I_shape_the_dough_into_loaves(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I bake the loaves in the oven for (\\d+) minutes$")
    public void i_bake_the_loaves_in_the_oven_for_minutes(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should have (\\d+) delicious loaves of bread$")
    public void i_should_have_delicious_loaves_of_bread(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions    throw new PendingException();
    }

}
