package util;

import model.Transition;

public class DotGenerator {

	private static final String NEW_LINE = "\n";
	private static final String DASH = ",";
	
	public static String transition2Dot(Transition t) {
		
		StringBuilder sb = new StringBuilder();
	
		sb.append(representTransition(t));
		sb.append(generateLabel(t));		
		
		return sb.toString();
	}
	
	private static String generateLabel(Transition t) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[label=\"");
		sb.append(representParam(t));
		sb.append("\"];" + NEW_LINE);
		
		return sb.toString();
	}
	
	private static String representParam(Transition t) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" e : " + t.getEvent() + DASH);
		//sb.append(" target : " + t.getTargets());
		sb.append(" time : " + t.getTimestamp()+ DASH);
		sb.append(" x : " + t.getX() + DASH);
		sb.append(" y : " + t.getY());
		
		return sb.toString();
	}
	
	private static String representTransition(Transition t) {
		return t.getSrc().toString() + "->" + t.getDst().toString();
	}
	
}
