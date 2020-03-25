package br.com.mind5.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public final class InfoPrunerHelper<T extends InfoRecord, S extends InfoRecord> implements InfoPruner<T, S> {
	private final List<T> bases; 
	private final List<S> seles;	
	private InfoPrunerSingleVisitor<T,S> singlePruner;
	private InfoPrunerListVisitor<T,S> listPruner;
	private final Class<?> prunerClazz;
	
	
	public InfoPrunerHelper(List<T> baseInfos, List<S> selectedInfos, InfoPrunerSingleVisitor<T, S> visitor) {
		checkArgument(baseInfos, selectedInfos, visitor);
		
		bases = InfoUtil.copy(baseInfos);
		seles = InfoUtil.copy(selectedInfos);		
		prunerClazz = visitor.getClass();
		singlePruner = visitor;
	}
	
	
	
	public InfoPrunerHelper(List<T> baseInfos, List<S> selectedInfos, InfoPrunerListVisitor<T, S> visitor) {
		checkArgument(baseInfos, selectedInfos, visitor);
		
		bases = InfoUtil.copy(baseInfos);
		seles = InfoUtil.copy(selectedInfos);		
		prunerClazz = visitor.getClass();
		listPruner = visitor;
	}
	
	
	
	@Override public List<T> prune() {
		if (seles.isEmpty())
			return InfoUtil.copy(bases);
			
		List<T> baseInfos = InfoUtil.copy(bases); 
		List<S> selectedInfos = InfoUtil.copy(seles);
		
		return pruneWithVisitor(baseInfos, selectedInfos, singlePruner, listPruner);
	}
	
	
	
	private List<T> pruneWithVisitor(List<T> baseInfos, List<S> selectedInfos, InfoPrunerSingleVisitor<T,S> single, InfoPrunerListVisitor<T,S> list) {
		if (single != null)		
			return pruneWithSingleVisitor(baseInfos, selectedInfos, single);
		
		return pruneWithListVisitor(baseInfos, selectedInfos, list);
	}
	
	
	
	private List<T> pruneWithSingleVisitor(List<T> baseInfos, List<S> selectedInfos, InfoPrunerSingleVisitor<T,S> visitor) {
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
	
	
	
	private List<T> pruneWithListVisitor(List<T> baseInfos, List<S> selectedInfos, InfoPrunerListVisitor<T,S> visitor) {
		return visitor.pruneRecord(baseInfos, selectedInfos);
	}
	
	
	
	private boolean pruneWithVisitor(T baseInfo, S selectedInfo, InfoPrunerSingleVisitor<T,S> visitor) {		
		if(visitor.shouldPrune(baseInfo, selectedInfo))
			return visitor.pruneRecord(baseInfo, selectedInfo);
		
		return false;
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<S> selectedInfos, InfoPrunerSingleVisitor<T, S> visitor) {
		checkArgument(baseInfos, selectedInfos);
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<S> selectedInfos, InfoPrunerListVisitor<T, S> visitor) {
		checkArgument(baseInfos, selectedInfos);
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<S> selectedInfos) {
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
	}
	
	
	
	private void logException(Exception e) {
		Class<?> clazz = prunerClazz;
		
		if (clazz == null)
			clazz = this.getClass();
		
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}
}
