package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryMealRepository implements MealRepository {
    private CopyOnWriteArrayList<Meal> meals;

    public InMemoryMealRepository(CopyOnWriteArrayList<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public Meal save(Meal meal) {
        Objects.requireNonNull(meal);

        if (meal.getId() == 0) {
            meals.add(meal);
        } else {
            meals.set(meal.getId(),meal);
        }

        return meal;
    }

    @Override
    public void delete(int id) {
        Objects.requireNonNull(meals);
        Iterator<Meal> iterator = meals.iterator();

        while (iterator.hasNext()){
            Meal meal = iterator.next();
            if(meal.getId() == id){
                iterator.remove();
                return;
            }
        }

    }

    @Override
    public Meal getById(int id) {
        Objects.requireNonNull(meals);

        for (Meal meal : meals) {
            if (meal.getId() == id) {
                return meal;
            }
        }
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }
}
