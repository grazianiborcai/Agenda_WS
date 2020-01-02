package br.com.mind5.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public final class InfoPrunerHelper<T extends InfoRecord, S extends InfoRecord> implements InfoPruner<T, S> {
	private final List<T> bases; 
	private final List<S> seles;	
	private final InfoPrunerVisitor<T,S> pruner;
	private final Class<?> prunerClazz;
	
	
	public InfoPrunerHelper(List<T> baseInfos, List<S> selectedInfos, InfoPrunerVisitor<T, S> visitor) {
		super();
		checkArgument(baseInfos, selectedInfos, visitor);
		
		bases = InfoUtil.copy(baseInfos);
		seles = InfoUtil.copy(selectedInfos);		
		prunerClazz = visitor.getClass();
		pruner = visitor;
	}
	
	
	
	@Override public List<T> prune() {
		if (seles.isEmpty())
			return InfoUtil.copy(bases);
			
		List<T> baseInfos = InfoUtil.copy(bases); 
		List<S> selectedInfos = InfoUtil.copy(seles);
		
		return pruneWithVisitor(baseInfos, selectedInfos, pruner);
	}
	
	
	
	private List<T> pruneWithVisitor(List<T> baseInfos, List<S> selectedInfos, InfoPrunerVisitor<T,S> visitor) {
		List<T> results = new ArrayList<>();				
		
		for (T eachBase : baseInfos) {	
			boolean pruneResult = false;
			
			for (S eachSelected : selectedInfos) {		
				if (pruneResult == false)
					pruneResult = pruneWithVisitor(eachBase, eachSelected, visitor);
			}			
			
			if (pruneResult == false)
				results.add(eachBase);
		}	
		
		
		return results;
	}
	
	
	
	private boolean pruneWithVisitor(T baseInfo, S selectedInfo, InfoPrunerVisitor<T,S> visitor) {		
		if(visitor.shouldPrune(baseInfo, selectedInfo))
			return visitor.pruneRecord(baseInfo, selectedInfo);
		
		return false;
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<S> selectedInfos, InfoPrunerVisitor<T, S> visitor) {
		if (baseInfos == null) {
			logException(new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (selectedInfos == null) {
			logException(new NullPointerException("selectedInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("selectedInfos" + SystemMessage.NULL_ARGUMENT);		
		}
		
		
		if (baseInfos.isEmpty()) {
			logException(new IllegalArgumentException("baseInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("baseInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(prunerClazz);
		logger.error(e.getMessage(), e);
	}
}
