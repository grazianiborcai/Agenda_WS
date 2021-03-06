package br.com.mind5.info;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public final class InfoMergerBuilder<T extends InfoRecord, K extends InfoRecord> {
	private List<T> bases; 
	private List<K> seles;
	private InfoMergerVisitor<T, K> merger;	
	
	
	public void addBaseInfo(T baseInfo) {
		bases.addAll(InfoUtil.copyToList(baseInfo));
	}
	
	
	
	public void addBaseInfos(List<T> baseInfos) {
		bases = InfoUtil.copy(baseInfos);
	}
	
	
	
	public void addSelectedInfo(K selectedInfo) {
		seles.addAll(InfoUtil.copyToList(selectedInfo));
	}
	
	
	
	public void addSelectedInfos(List<K> selectedInfos) {
		seles = InfoUtil.copy(selectedInfos);
	}
	
	
	
	public void addVisitor(InfoMergerVisitor<T, K> visitor) {
		merger = visitor;
	}	
	
	
	
	public InfoMerger<T, K> build() {
		checkArgument(bases, seles, merger);
		return new InfoMergerHelper<T, K>(bases, seles, merger);
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<K> selectedInfos, InfoMergerVisitor<T, K> visitor) {
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
