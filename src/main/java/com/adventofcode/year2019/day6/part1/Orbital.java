package com.adventofcode.year2019.day6.part1;

import com.adventofcode.util.AbstractProblemSolution;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Orbital extends AbstractProblemSolution {

  Map<String, Orbit> orbits;

  public Orbital() {
    this.orbits = new HashMap<>();
    Orbit com = new Orbit("COM");
    this.orbits.put("COM", com);
  }

  public static void main(String[] args) {
    new Orbital().solve();
  }

  private int solve() {
    processInput(getInputLines("./src/main/resources/2019/day/6/input").toList());
    return countOrbits(orbits.get("COM"),
        -1); // as COM doesn't orbit we need to start at 0 in the function
  }

  private int countOrbits(Orbit orbit, int partialResult) {
    int result = partialResult + 1;

    for (Orbit o : orbit.getOrbits()) {
      result += countOrbits(o, partialResult + 1);
    }

    return result;
  }

  private void processInput(List<String> inputLines) {
    for (String line : inputLines) {
      String[] split = line.split("\\)");
      Orbit centre = getOrCreateOrbit(split[0]);
      Orbit planet = getOrCreateOrbit(split[1]);
      centre.addOrbit(planet);
    }
  }

  private Orbit getOrCreateOrbit(String name) {
    Orbit result;
    if (!orbits.containsKey(name)) {
      result = new Orbit(name);
      orbits.put(name, result);
    } else {
      result = orbits.get(name);
    }
    return result;
  }

  class Orbit {

    String id;
    List<Orbit> orbits = new LinkedList<>();

    Orbit(String id) {
      this.id = id;
    }

    void addOrbit(Orbit o) {
      orbits.add(o);
    }

    public String getId() {
      return id;
    }

    public List<Orbit> getOrbits() {
      return orbits;
    }

    @Override
    public String toString() {
      return "Orbit{" +
          "id='" + id + '\'' +
          ", orbits=" + orbits +
          '}';
    }
  }
}
