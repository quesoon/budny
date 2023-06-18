package org.semul.budny.heroeswm;

import java.util.Map;

import static java.util.Map.entry;

public class HeroesWMStructure {
    // Paths.
    public static final String URL = "https://www.heroeswm.ru/";
    public static final String LOGIN_PATH = "login.php";
    public static final String HOME_PATH = "home.php";
    public static final String MAP_PATH = "map.php";

    // Districts map.
    public static final Map<String, String> DISTRICTS = Map.ofEntries(
            entry("Ungovernable Steppe", "cx=48&cy=48"),
            entry("Eagle Nest", "cx=49&cy=48"),
            entry("Peaceful Camp", "cx=50&cy=48"),
            entry("Crystal Garden", "cx=51&cy=48"),
            entry("Fairy Trees", "cx=52&cy=48"),
            entry("Sunny City", "cx=48&cy=49"),
            entry("Shining Spring", "cx=49&cy=49"),
            entry("Tiger Lake", "cx=50&cy=49"),
            entry("Rogues' Wood", "cx=51&cy=49"),
            entry("Bear Mountain", "cx=52&cy=49"),
            entry("Mithril Coast", "cx=53&cy=49"),
            entry("Sublime Arbor", "cx=48&cy=50"),
            entry("Green Wood", "cx=49&cy=50"),
            entry("Empire Capital", "cx=50&cy=50"),
            entry("East River", "cx=51&cy=50"),
            entry("Magma Mines", "cx=52&cy=50"),
            entry("Harbour City", "cx=53&cy=50"),
            entry("Lizard Lowland", "cx=49&cy=51"),
            entry("Wolf Dale", "cx=50&cy=51"),
            entry("Dragons' Caves", "cx=51&cy=51"),
            entry("The Wilderness", "cx=49&cy=52"),
            entry("Portal Ruins", "cx=50&cy=52"),
            entry("Great Wall", "cx=51&cy=52"),
            entry("Titans' Valley", "cx=51&cy=53"),
            entry("Fishing Village", "cx=52&cy=53"),
            entry("Kingdom Castle", "cx=52&cy=54")
    );

    // Vacancies.
    public static final String[] STRUCTURES = new String[]{"sh", "fc", "mn"};

    // Employment Status.
    public static final String free = "Вы нигде не работаете.";
    public static final String freeSoon = "Последнее место работы:";
}
