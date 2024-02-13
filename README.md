<a name="readme-top"></a>


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h1 align="center">Mars Exploration</h1>

  <p align="center">
    Embark on an exciting journey to explore Mars through simulated mapping!
    <br />
    <a href="https://github.com/somavrg/mars-exploration"><strong>GitHub Repository</strong></a>
    <br />
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#story">Story</a></li>
        <li><a href="#task">Task</a></li>
      </ul>
    </li>
    <li>
      <a href="#general-info">General Info</a>
      <ul>
        <li><a href="#tasks">Tasks</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

### Story

Humanity's journey to colonize Mars has commenced. To ensure the success of this monumental endeavor, extensive simulation exercises are imperative. Our team has been tasked with developing an application to generate randomized maps of Mars to aid in calibrating the software for Mars rovers.

### Task

Our objective is to create a robust application capable of generating randomized maps of Mars based on specific input requirements. These requirements may vary, necessitating a flexible software solution. The application should:

- Generate four types of objects: mountains (^), pits (#), minerals (*), and pockets of water (~).
- Configure the areas covered by different terrain elements and resources.
- Generate random shapes for mountains and pits without overlap.
- Place mineral resource points next to mountains and pockets of water next to pits.
- Save the generated map into a plain text file.

## General Info

- Implement SOLID principles.
- Utilize file I/O for writing text files.
- Structure complex algorithms into multiple steps and classes.
- Apply design principles such as SLAP (Single Level of Abstraction Principle) and YAGNI (You Aren't Gonna Need It).

## Tasks

### Map Configuration

- Define a configuration object containing the file name, map width, terrain element symbols, resource symbols, and areas of 2D-regions.
- Ensure the generated map varies with each run according to provided parameters.

### Shape Generation and Placement

- Randomly generate shapes for mountains and pits with the given areas.
- Place mountains and pits within the map boundaries without overlap.
- Unit test the shape generation and placement code.

### Resource Placement

- Place mineral and water units adjacent to mountains and pits, respectively, if feasible.

### Save Output

- Save the generated map into a plain text file specified in the configuration.

<!-- USAGE EXAMPLES -->
## Usage

Before running the application, ensure you have the following prerequisites installed on your computer:
- Java Development Kit (JDK)

To run the application, execute the `Application` class. Specify the file path where you want to save the generated maps using the `filePath` parameter.
