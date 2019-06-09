package br.com.gda.message.emailBody.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class EmabodyMerger {
	public static EmabodyInfo mergeToSelect(EmabodyInfo sourceOne, EmabodyInfo sourceTwo) {
		InfoMerger<EmabodyInfo, EmabodyInfo> merger = new EmabodyMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmabodyInfo> mergeToSelect(List<EmabodyInfo> sourceOnes, List<EmabodyInfo> sourceTwos) {
		InfoMerger<EmabodyInfo, EmabodyInfo> merger = new EmabodyMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
