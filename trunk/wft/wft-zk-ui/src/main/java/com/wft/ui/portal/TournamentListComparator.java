package com.wft.ui.portal;

import java.io.Serializable;
import java.util.Comparator;

import com.wft.model.tournament.Tournament;

public class TournamentListComparator implements Comparator<Tournament>, Serializable {

  public TournamentListComparator() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int compare(Tournament arg0, Tournament arg1) {
    return arg0.getCategory().compareTo(arg1.getCategory());
  }

  

}