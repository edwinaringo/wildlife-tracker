import static spark.Spark.*;

import models.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        get("/sightings/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sightings.all());
            return new ModelAndView(model,"sightings-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/sightings/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String rangerName = request.queryParams("rangerName");
            String animalName = request.queryParams("animalName");
            String animalHealth = request.queryParams("animalHealth");
            String animalType = request.queryParams("animalType");
            String animalAge = request.queryParams("animalAge");
            String location = request.queryParams("location");

            Ranger newRanger = new Ranger(rangerName);
            newRanger.save();

            if(animalType.equalsIgnoreCase("Endangered")){
                EndangeredAnimals endangeredAnimals = new EndangeredAnimals(animalName,animalHealth,animalAge);
                endangeredAnimals.save();
                Sightings newSighting = new Sightings(endangeredAnimals.getName(),location,newRanger.getId());
                newSighting.save();
            }
            else{
                SafeAnimals safeAnimals = new SafeAnimals(animalName,animalHealth,animalAge);
                safeAnimals.save();
                Sightings newSightings = new Sightings(safeAnimals.getName(),location,newRanger.getId());
                newSightings.save();
            }
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get("/sightings",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sightings.all());
            return new ModelAndView(model,"sightings.hbs");
        },new HandlebarsTemplateEngine());

        get("/sightings/:location/details",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String filter = request.params("location");
            model.put("location",filter);
            model.put("sightings", Sightings.getSightingsInLocation(filter));
            return new ModelAndView(model,"sighting-details.hbs");
        },new HandlebarsTemplateEngine());

        get("/animals/endangered",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("endangered", EndangeredAnimals.allEndangeredAnimals());
            return new ModelAndView(model,"endangered-animals.hbs");
        },new HandlebarsTemplateEngine());

        get("/animals/safe",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("safe", SafeAnimals.allSafeAnimals());
            return new ModelAndView(model,"safe-animals.hbs");
        },new HandlebarsTemplateEngine());

        get("/rangers/:id/details",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params("id"));
            Ranger rangers = Ranger.find(id);
            List<Sightings> rangerSightings = rangers.rangerSightings();
            model.put("ranger",rangers);
            model.put("sightings",rangerSightings);
            return new ModelAndView(model,"ranger-details.hbs");
        },new HandlebarsTemplateEngine());

        get("/rangers",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("rangers", Ranger.allRangers());
            return new ModelAndView(model,"rangers.hbs");
        },new HandlebarsTemplateEngine());


    }



}



