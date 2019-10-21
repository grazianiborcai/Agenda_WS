package br.com.mind5.model.action.commom;

import java.util.Comparator;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorEnforce;


public abstract class ActionVisitorTemplateSort<T extends Comparable<T>> implements ActionVisitorEnforce<T> {
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {		
		recordInfos.sort(Comparator.naturalOrder());
		return recordInfos;
	}	
}
