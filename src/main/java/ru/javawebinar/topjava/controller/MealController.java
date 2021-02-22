package ru.javawebinar.topjava.controller;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MealController {
    public CopyOnWriteArrayList<Meal> meals = new CopyOnWriteArrayList<>();
    private static int counter = 0;
    private MealRepository repository;

    public MealController(MealRepository repository) {
        this.repository = repository;
    }

    public Meal save (Meal meal){
        counter++;
        meal.setId(counter);
        repository.save(meal);
    };

    void delete (int id);
    Meal getById (int id);
    List<Meal> getAll ();
}
