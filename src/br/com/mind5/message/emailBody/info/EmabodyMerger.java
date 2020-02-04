package br.com.mind5.message.emailBody.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmabodyMerger {
	public static EmabodyInfo mergeToSelect(EmabodyInfo sourceOne, EmabodyInfo sourceTwo) {
		InfoMerger_<EmabodyInfo, EmabodyInfo> merger = new EmabodyMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmabodyInfo> mergeToSelect(List<EmabodyInfo> sourceOnes, List<EmabodyInfo> sourceTwos) {
		InfoMerger_<EmabodyInfo, EmabodyInfo> merger = new EmabodyMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
