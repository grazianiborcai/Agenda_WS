package br.com.gda.model.action;

import java.util.Comparator;
import java.util.List;


public abstract class ActionVisitorTemplateSort<T extends Comparable<T>> implements ActionVisitor<T> {
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {		
		recordInfos.sort(Comparator.naturalOrder());
		return recordInfos;
	}	
}
