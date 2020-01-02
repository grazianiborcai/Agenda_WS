package br.com.mind5.info.temp;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class InfoPrunerBuilder<T extends InfoRecord, S extends InfoRecord> {
	private List<T> bases; 
	private List<S> seles;
	private InfoPrunerVisitorV2<T, S> pruner;	
	
	
	public void addBaseInfos(List<T> baseInfos) {
		bases = InfoUtil.copy(baseInfos);
	}
	
	
	
	public void addSelectedInfos(List<S> selectedInfos) {
		seles = InfoUtil.copy(selectedInfos);
	}
	
	
	
	public void addVisitor(InfoPrunerVisitorV2<T, S> visitor) {
		pruner = visitor;
	}	
	
	
	
	public InfoPrunerV2<T, S> build() {
		checkArgument(bases, seles, pruner);
		return new InfoPrunerHelper<T, S>(bases, seles, pruner);
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<S> selectedInfos, InfoPrunerVisitorV2<T, S> visitor) {
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
