package com.bematech.material.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageUrlUtils {

    public static String[] getImageUrls() {
        String[] urls = new String[]{
                "https://static.pexels.com/photos/5854/sea-woman-legs-water-medium.jpg",
                "https://static.pexels.com/photos/6245/kitchen-cooking-interior-decor-medium.jpg",
                "https://static.pexels.com/photos/6770/light-road-lights-night-medium.jpg",
                "https://static.pexels.com/photos/6041/nature-grain-moving-cereal-medium.jpg",
                "https://static.pexels.com/photos/7116/mountains-water-trees-lake-medium.jpg",
                "https://static.pexels.com/photos/6601/food-plate-yellow-white-medium.jpg",
                "https://static.pexels.com/photos/6695/summer-sun-yellow-spring-medium.jpg",
                "https://static.pexels.com/photos/7117/mountains-night-clouds-lake-medium.jpg",
                "https://static.pexels.com/photos/7262/clouds-ocean-seagull-medium.jpg",
                "https://static.pexels.com/photos/5968/wood-nature-dark-forest-medium.jpg",
                "https://static.pexels.com/photos/6101/hands-woman-art-hand-medium.jpg",
                "https://static.pexels.com/photos/6571/pexels-photo-medium.jpeg",
                "https://static.pexels.com/photos/6740/food-sugar-lighting-milk-medium.jpg",
                "https://static.pexels.com/photos/5659/sky-sunset-clouds-field-medium.jpg",
                "https://static.pexels.com/photos/6945/sunset-summer-golden-hour-paul-filitchkin-medium.jpg",
                "https://static.pexels.com/photos/6151/animal-cute-fur-white-medium.jpg",
                "https://static.pexels.com/photos/5696/coffee-cup-water-glass-medium.jpg",
                "https://static.pexels.com/photos/6789/flowers-petals-gift-flower-medium.jpg",
                "https://static.pexels.com/photos/7202/summer-trees-sunlight-trail-medium.jpg",
                "https://static.pexels.com/photos/7147/night-clouds-summer-trees-medium.jpg",
                "https://static.pexels.com/photos/6342/woman-notebook-working-girl-medium.jpg",
                "https://static.pexels.com/photos/5998/sky-love-people-romantic-medium.jpg",
                "https://static.pexels.com/photos/6872/cold-snow-nature-weather-medium.jpg",
                "https://static.pexels.com/photos/7045/pexels-photo-medium.jpeg",
                "https://static.pexels.com/photos/6923/mountains-fog-green-beauty-medium.jpg",
                "https://static.pexels.com/photos/6946/summer-bicycle-letsride-paul-filitchkin-medium.jpg",
                "https://static.pexels.com/photos/5650/sky-clouds-field-blue-medium.jpg",
                "https://static.pexels.com/photos/6292/blue-pattern-texture-macro-medium.jpg",
                "https://static.pexels.com/photos/6080/grass-lawn-technology-tablet-medium.jpg",
                "https://static.pexels.com/photos/7124/clouds-trees-medium.jpg",
                "https://static.pexels.com/photos/5923/woman-girl-teenager-wine-medium.jpg",
                "https://static.pexels.com/photos/6133/food-polish-cooking-making-medium.jpg",
                "https://static.pexels.com/photos/6224/hands-people-woman-working-medium.jpg",
                "https://static.pexels.com/photos/6414/rucola-young-argula-sproutus-medium.jpg",
                "https://static.pexels.com/photos/6739/art-graffiti-abstract-vintage-medium.jpg",
                "https://static.pexels.com/photos/6703/city-train-metal-public-transportation-medium.jpg",
                "https://static.pexels.com/photos/6851/man-love-woman-kiss-medium.jpg",
                "https://static.pexels.com/photos/6225/black-scissors-medium.jpg",
                "https://static.pexels.com/photos/7185/night-clouds-trees-stars-medium.jpg",
                "https://static.pexels.com/photos/5847/fashion-woman-girl-jacket-medium.jpg",
                "https://static.pexels.com/photos/5542/vintage-railroad-tracks-bw-medium.jpg",
                "https://static.pexels.com/photos/5938/food-salad-healthy-lunch-medium.jpg",
                "https://static.pexels.com/photos/7234/water-clouds-ocean-splash-medium.jpg",
                "https://static.pexels.com/photos/6418/flowers-flower-roses-rose-medium.jpg",
                "https://static.pexels.com/photos/6436/spring-flower-hyacinth-medium.jpg",
                "https://static.pexels.com/photos/6351/smartphone-desk-laptop-technology-medium.jpg",
                "https://static.pexels.com/photos/5618/fish-fried-mint-pepper-medium.jpg",
                "https://static.pexels.com/photos/6874/landscape-nature-water-rocks-medium.jpg",
                "https://static.pexels.com/photos/6918/bridge-fog-san-francisco-lets-get-lost-medium.jpg",
                "https://static.pexels.com/photos/5658/light-sunset-red-flowers-medium.jpg",
                "https://static.pexels.com/photos/6111/smartphone-friends-internet-connection-medium.jpg"
        };

        return urls;
    }

    public static List<String> getImageUrlList() {

        List<String> strings = Arrays.asList(getImageUrls());
        return strings;
    }


    public static CustomBeacon createCustomBeacon(String nomeSetor, int qtdColaboradores) {

        List<String> imageUrlList = getImageUrlList();
        ArrayList<Colaborador> colaboradores = new ArrayList<>();
        CustomBeacon customBeacon = new CustomBeacon();

        Setor setor = new Setor();
        setor.setNome(nomeSetor);

        for (int i = 0; i < qtdColaboradores; i++) {
            Colaborador colaborador = new Colaborador();
            colaborador.setNome("Colaborador " + String.valueOf(i));
            colaborador.setEmail("colaborador" + String.valueOf(i) + "@bematech.com.br");
            colaborador.setImageUrl(imageUrlList.get(i));
            colaboradores.add(colaborador);
        }
        setor.setColaboradores(colaboradores);
        customBeacon.setSetor(setor);

        return customBeacon;

    }

    public static ArrayList<Setor> geraListaSetores() {

        ArrayList<Setor> setores = new ArrayList<>();
        List<String> imageUrlList = getImageUrlList();
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Setor setor = new Setor();
            setor.setNome("Setor " + String.valueOf(i + 1));

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 10; k++) {
                    Colaborador colaborador = new Colaborador();
                    colaborador.setNome("Colaborador " + String.valueOf(j + 1));
                    colaborador.setEmail("colaborador" + String.valueOf(j + 1) + "@bematech.com.br");
                    colaborador.setImageUrl(imageUrlList.get(i));

                    colaboradores.add(colaborador);
                    setor.setColaboradores(colaboradores);
                }
            }

            setores.add(setor);


        }

        return setores;

    }
}
