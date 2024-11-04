package com.adventofcode.year2019.day6.part2;

import com.adventofcode.util.AbstractProblemSolution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.ListUtils;

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
    return findShortestWay();
  }

  private int findShortestWay() {
    Orbit you = this.orbits.get("YOU");
    Orbit san = this.orbits.get("SAN");

    List<Orbit> pathToCOMYou = getPathToCOM(you);
    List<Orbit> pathToCOMSan = getPathToCOM(san);
    Orbit orbit = ListUtils.intersection(pathToCOMYou, pathToCOMSan).get(0);
    int santaDistance = pathToCOMSan.indexOf(orbit);
    int youDistance = pathToCOMYou.indexOf(orbit);

    System.out.println(pathToCOMSan);
    System.out.println(pathToCOMYou);

    return santaDistance + youDistance;
  }

  private List<Orbit> getPathToCOM(Orbit start) {
    List<Orbit> result = new ArrayList<>();
    Orbit parent = start.getParent();
    do {
      result.add(parent);
      parent = parent.getParent();
    } while (!parent.getId().equals("COM"));
    return result;
  }


  private void processInput(List<String> inputLines) {
    for (String line : inputLines) {
      String[] split = line.split("\\)");
      Orbit centre = getOrCreateOrbit(split[0]);
      Orbit planet = getOrCreateOrbit(split[1]);
      planet.setParent(centre);
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
    Orbit parent;
    List<Orbit> orbits = new LinkedList<>();

    Orbit(String id) {
      this.id = id;
    }

    Orbit(String id, Orbit parent) {
      this.id = id;
      this.parent = parent;
    }

    void addOrbit(Orbit o) {
      orbits.add(o);
    }

    public String getId() {
      return id;
    }

    public Orbit getParent() {
      return parent;
    }

    public void setParent(Orbit parent) {
      this.parent = parent;
    }

    public List<Orbit> getOrbits() {
      return orbits;
    }

    @Override
    public String toString() {
      return "Orbit{" +
          "id='" + id + '}';
//      return "Orbit{" +
//          "id='" + id + '\'' +
//          ", orbits=" + orbits +
//          '}';
    }
  }
}
