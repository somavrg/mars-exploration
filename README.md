# mars-exploration

### Story
Mars exploration
Looks like humanity will have a bright future after all: the colonization of Mars has finally started. But it is no 
small effort. To avoid wasting billions of dollars worth of equipment in space, a lot of simulation exercises need 
to be done – here on Earth.

To fully flesh out the Mars rovers software, sample maps are needed to calibrate its functions. This is where we came 
into the picture. Our team was selected to be a part of this wonderful adventure. 

## Task
Our task was to create an application that can generate randomized maps of Mars, based on some input requirements. 
These requirements can change quickly, so it had to be a robust software that can handle changing requirements 
in a flexible way.

Generates four types of objects: mountains (`^`), pits (`#`), minerals (`*`), and pockets of water (`~`). 
The first two are patch-like terrain elements (covering a 2D continuous area on the map), the latter two are point-like
resources (covering just one pixel on the map).

- The most important parameters are the areas covered by the different terrain elements (for example, three mountain regions are required, with areas `10`, `20`, and `30`, and two pits with areas `5` and `15`).
- A given number of mineral resource points must be placed next to mountain regions (if there is enough room), while a given number of pockets of water must be placed next to pits.

The map generator creates a new random map that conforms to the configuration parameters every time it runs. 

## General info
- Practice SOLID principles.
- Write text into files.
- Structure complex algorithms into multiple steps and classes.
- Practice other design principles such as SLAP and YAGNI.

## Tasks

1. Map configuration\
   - There is a configuration object that contains the file name, map width, and the symbols and numbers of different terrain elements and resources, as well as the areas of the 2D-regions.
   - The generated map is different every time it runs, in accordance with the provided parameters.


2. Shape generation and placement\
    - Mountains and pits have exactly the given area but a random shape.
    - Mountains and pits are placed within the boundaries of map without overlap.
    - The shape generator code is covered with unit tests.
    - The shape placer code is covered with unit tests.

3. Resource placement\
    - Mineral and water units are placed next to their preferences (mountains and pits, respectively) if possible.

4. Save output\
    - The generated map is saved into a plain text file specified in the configuration.

## Usage
The application can be run from the Application class, for the `filePath` you need to specify a path where 
you would like to save the generated maps.
