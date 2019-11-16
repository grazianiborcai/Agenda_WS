package br.com.mind5.model.action.commom;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionVisitorEnforce;


public final class ActionVisitorUniquify<T extends InfoRecord> implements ActionVisitorEnforce<T> {
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {		
		return recordInfos.stream().distinct().collect(Collectors.toList());
	}	
}
