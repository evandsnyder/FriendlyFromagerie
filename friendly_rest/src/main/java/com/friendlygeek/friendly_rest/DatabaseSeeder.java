package com.friendlygeek.friendly_rest;

import com.friendlygeek.friendly_rest.model.Recipe;
import com.friendlygeek.friendly_rest.model.Role;
import com.friendlygeek.friendly_rest.model.User;
import com.friendlygeek.friendly_rest.repository.RecipeRepository;
import com.friendlygeek.friendly_rest.repository.RoleRepository;
import com.friendlygeek.friendly_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DatabaseSeeder {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RecipeRepository recipeRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event){
        seedRoles();
        seedUsers();
        seedRecipes();
    }

    private void seedRoles() {
        if (roleRepository.count() > 0)
            return;

        Role role1 = new Role();
        role1.setId("e9046d3e-972c-11ec-b909-0242ac120002");
        role1.setRole("ADMIN");

        Role role2 = new Role();
        role2.setId("e9047036-972c-11ec-b909-0242ac120002");
        role2.setRole("USER");

        roleRepository.save(role1);
        roleRepository.save(role2);
    }

    private void seedUsers() {
        if (userRepository.count() > 0)
            return;

        User adminUser = new User();
        adminUser.setId("e90472a2-972c-11ec-b909-0242ac120002");
        adminUser.setActive(true);
        adminUser.setEmail("admin@admin.com");
        adminUser.setFirstName("Super");
        adminUser.setLastName("Admin");
        adminUser.setUsername("administrator");
        adminUser.setPhoneNumber("123-456-7890");
        adminUser.setPassword("adminpassword");

        Optional<Role> role = roleRepository.findById("e9046d3e-972c-11ec-b909-0242ac120002");
        role.ifPresent(value -> adminUser.getRoles().add(value));

        userRepository.save(adminUser);
    }

    private void seedRecipes() {
        if (recipeRepository.count() > 0)
            return;

        Recipe recipe1 = new Recipe();
        recipe1.setPublish(true);
        recipe1.setRecipeName("Simple Mozzarella");
        recipe1.setDescription("A nice, tasty mozzarella that's better than anything store-bought!");
        recipe1.setCheeseType("Mozzarella");
        recipe1.setHardness("SOFT");
        recipe1.setMilkType("COW");
        recipe1.setIngredients(
                "1 Gallon whole cow's milk. 1.5 tsp citric acid dissolved in 1/4 cup cool, non-chlorinated water. 1/8tsp lipase dissolved in 1/4 cup cool. non-chlorinated water and allowed to rest for 15 minutes. 1/8 tsp animal or microbial rennet dissolved in 1/4 cup cool. non-chlorinated water. 2Tsp coarse non-iodized salt");
        recipe1.setWarmTheMilk(
                "In a stockpot, heat the milk to 86F for 10 minutes in a warm water bath. Stir the milk gently to let it warm evenly");
        recipe1.setCultureAndCoagulate(
                "Add the citric acid and the lipase.. Mix thoroughly into the milk and then let rest for 15 minutes. Bring the temperature of the milk to 90F in the water bath. Add the rennet, stir with the up and down technique for 1 minute. Cover and let rest for 20 minutes or until the curd is more like a custard.");
        recipe1.setLadleTheCurd(
                "Cut the curd into 1/2 inch pieces using the straight and angled technique. Heat in water bath to 110 while constantly stirring gently. let rest at 110F for 10 minutes. Ladle the curd into a medium bowl");
        recipe1.setDrainTheCurd(
                "Press the curds in the bowl with a spoon while tilting to expel whey. Mozzarella also has a stretching process but that is simply down with a salted brine and a folding technique.");
        recipe1.setTargetFlavorAndTexture(
                "Fresh mozzarella should be milky and sweet. Expect a smooth texture bursting with moisture.");
        recipe1.setStorage(
                "Eat this quickly! it is best enjoyed fresh but can be stored in a plastic container for 2-3 days.");
        recipe1.setNotes("Don't overwork the curd while stretching, you'll end up with a grainier, harder cheese.");

        recipeRepository.save(recipe1);
    }
}
