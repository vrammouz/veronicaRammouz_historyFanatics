package com.example.veronica.historyfanatics;

import java.util.Random;

/**
 * Created by Veronica on 5/13/2019.
 */
public class StoriesInHistory
{
    public Story[] eventsArray =
    {
        new Story(1945,"Malmedy massacre","World War II: In retaliation for the Malmedy massacre, U.S. troops kill 60 German POWs at Chenogne."),
        new Story(1945, "Allies of World War II","World War II: The German Luftwaffe launches Operation Bodenplatte, a massive, but failed attempt to knock out Allied air power in northern Europe in a single blow."),
        new Story(1945,"Bizone","The American and British occupation zones in Germany, after World War II, merge to form the Bizone, which later (with the French zone) became part of West Germany."),
        new Story(1955,"Mary Beard (classicist)","Mary Beard, English scholar, academic, and classicist"),
        new Story(1955,"LaMarr Hoyt","LaMarr Hoyt, American baseball player"),
        new Story(1955,"Gennady Lyachin","Gennady Lyachin, Russian captain (d. 2000)"),
        new Story(1955,"Precious (wrestling)","Precious, Canadian wrestler and manager"),
        new Story(1919,"Buenos Aires Convention","Uruguay becomes a signatory to the Buenos Aires copyright treaty."),
        new Story(1938, "Nuclear fission","Otto Hahn discovers the nuclear fission of the heavy element uranium, the scientific and technological basis of nuclear energy."),
        new Story(1896 , "Schenley Park Casino","Pittsburgh, Pennsylvania's Schenley Park Casino, which was the first multi-purpose arena with the technology to create an artificial ice surface in North America, is destroyed in a fire."),
        new Story(1903, "Kitty Hawk, North Carolina","The Wright brothers make the first controlled powered, heavier-than-air flight in the Wright Flyer at Kitty Hawk, North Carolina."),
        new Story(1918, "Darwin Rebellion","Darwin Rebellion: Up to 1,000 demonstrators march on Government House in Darwin, Northern Territory, Australia."),
        new Story(1862, "American Civil War","American Civil War: General Ulysses S. Grant issues General Order No. 11, expelling Jews from parts of Tennessee, Mississippi, and Kentucky."),
        new Story(1865, "Symphony No. 8 (Schubert)","First performance of the Unfinished Symphony by Franz Schubert."),
        new Story(1892, "Vogue","First issue of Vogue is published."),
        new Story(1837, "Fire in the Winter Palace","A fire in the Winter Palace of Saint Petersburg kills 30 guards."),
        new Story(1835, "Great Fire of New York","The second Great Fire of New York destroys 50 acres (200,000 square meters) of New York City's Financial District."),
        new Story(1819, "Gran Colombia","Simón Bolívar declares the independence of Gran Colombia in Angostura (now Ciudad Bolívar in Venezuela)."),
        new Story(1812, "War of 1812","War of 1812: U.S. forces attack a Lenape village in the Battle of the Mississinewa."),
        new Story(1807, "Napoleonic Wars","Napoleonic Wars: France issues the Milan Decree, which confirms the Continental System."),
        new Story(1790, "Aztec calendar stone","The Aztec calendar stone is discovered at El Zócalo, Mexico City."),
        new Story(1718, "War of the Quadruple Alliance","War of the Quadruple Alliance: Great Britain declares war on Spain."),
        new Story(1583, "Cologne War","Cologne War: Forces under Ernest of Bavaria defeat troops under Gebhard Truchsess von Waldburg at the Siege of Godesberg."),
        new Story(1538, "Pope Paul III","Pope Paul III excommunicates Henry VIII of England."),
        new Story(1398, "Tughlaq dynasty","Sultan Nasir-u Din Mehmud's armies in Delhi are defeated by Timur."),
        new Story(942, "William I of Normandy","Assassination of William I of Normandy."),
        new Story(920, "Romanos I Lekapenos","Romanos I Lekapenos is crowned co-emperor of the underage Constantine VII."),
        new Story(546, "Sack of Rome (546)","Siege of Rome: The Ostrogoths under king Totila plunder the city, by bribing the Byzantine garrison."),
        new Story(1939, "Battle of the River Plate","World War II: Battle of the River Plate: The Admiral Graf Spee is scuttled by Captain Hans Langsdorff outside Montevideo."),
        new Story(1947, "Boeing B-47 Stratojet","First flight of the Boeing B-47 Stratojet strategic bomber."),
        new Story(1948, "Finnish Security Intelligence Service","The Finnish Security Police is established to remove communist leadership from its predecessor, the State Police."),
        new Story(1951, "We Charge Genocide","The American Civil Rights Congress delivers \\\\\\\"We Charge Genocide\\\\\\\" to the United Nations."),
        new Story(1957, "SM-65 Atlas","The United States successfully launches the first Atlas intercontinental ballistic missile at Cape Canaveral, Florida."),
        new Story(1960, "1960 Ethiopian coup attempt","Troops loyal to Emperor Haile Selassie in Ethiopia crush the coup that began December 13, returning power to their leader upon his return from Brazil. Haile Selassie absolves his son of any guilt."),
        new Story(1960, "1960 Munich C-131 crash","Munich C-131 crash: Twenty passengers and crew on board as well as 32 people on the ground are killed."),
        new Story(1961, "Niterói circus fire","Niterói circus fire: Fire breaks out during a performance by the Gran Circus Norte-Americano in the city of Niterói, Rio de Janeiro, Brazil, killing more than 500."),
        new Story(1955,"Mary Beard (classicist)","Mary Beard, English scholar, academic, and classicist"),
        new Story(1955, "LaMarr Hoyt","LaMarr Hoyt, American baseball player"),
        new Story(1955,"Gennady Lyachin","Gennady Lyachin, Russian captain (d. 2000)"),
        new Story(1955,"Precious (wrestling)","Precious, Canadian wrestler and manager")
    };

    public String getStoryTitle(Story st){return st.getTitle();}
    public Story getRandomStory()
    {
        Random random = new Random();
        int storyNumber = random.nextInt(eventsArray.length);

        return eventsArray[storyNumber];
    }
}
