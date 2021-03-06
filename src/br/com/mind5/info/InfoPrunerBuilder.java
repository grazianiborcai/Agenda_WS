package br.com.mind5.info;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public final class InfoPrunerBuilder<T extends InfoRecord, S extends InfoRecord> {
	private List<T> bases; 
	private List<S> seles;
	private InfoPrunerSingleVisitor<T, S> singlePruner;	
	private InfoPrunerListVisitor<T, S> listPruner;	
	
	
	public void addBaseInfos(List<T> baseInfos) {
		bases = InfoUtil.copy(baseInfos);
	}
	
	
	
	public void addSelectedInfos(List<S> selectedInfos) {
		seles = InfoUtil.copy(selectedInfos);
	}
	
	
	
	public void addVisitor(InfoPrunerSingleVisitor<T, S> visitor) {
		singlePruner = visitor;
		listPruner = null;
	}	
	
	
	
	public void addVisitor(InfoPrunerListVisitor<T, S> visitor) {
		listPruner = visitor;
		singlePruner = null;
	}	
	
	
	
	public InfoPruner<T, S> build() {
		if (singlePruner != null)
			return buildSinglePruner();
		
		return buildListPruner();
	}
	
	
	
	private InfoPruner<T, S> buildSinglePruner() {
		checkArgument(bases, seles, singlePruner);
		return new InfoPrunerHelper<T, S>(bases, seles, singlePruner);
	}
	
	
	
	private InfoPruner<T, S> buildListPruner() {
		checkArgument(bases, seles, listPruner);
		return new InfoPrunerHelper<T, S>(bases, seles, listPruner);
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<S> selectedInfos, Object visitor) {
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
		SystemLog.logError(this.getClass(), e);
	}
}
