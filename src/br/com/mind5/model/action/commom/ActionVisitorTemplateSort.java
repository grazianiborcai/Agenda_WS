package br.com.mind5.model.action.commom;

import java.util.Comparator;
import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionVisitorEnforce;


public abstract class ActionVisitorTemplateSort<T extends InfoRecord> implements ActionVisitorEnforce<T> {
	
	@SuppressWarnings("unchecked")
	@Override public List<T> executeTransformation(List<T> recordInfos) {		
		recordInfos.sort((Comparator<? super T>) Comparator.naturalOrder());
		return recordInfos;
	}	
}
