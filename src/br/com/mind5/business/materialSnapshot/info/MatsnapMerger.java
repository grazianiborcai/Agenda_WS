package br.com.mind5.business.materialSnapshot.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

public final class MatsnapMerger {	
	public static MatsnapInfo mergeWithMateg(MategInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MategInfo> merger = new MatsnapMergerMateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMateg(List<MategInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MategInfo> merger = new MatsnapMergerMateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatGroup(MatGroupInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatGroupInfo> merger = new MatsnapMergerMatGroup();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatGroup(List<MatGroupInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatGroupInfo> merger = new MatsnapMergerMatGroup();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatype(MatypeInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatypeInfo> merger = new MatsnapMergerMatype();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatype(List<MatypeInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatypeInfo> merger = new MatsnapMergerMatype();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatUnit(MatUnitInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatUnitInfo> merger = new MatsnapMergerMatUnit();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatUnit(List<MatUnitInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatUnitInfo> merger = new MatsnapMergerMatUnit();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatextsnap(MatextsnapInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatextsnapInfo> merger = new MatsnapMergerMatextsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatextsnap(List<MatextsnapInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatextsnapInfo> merger = new MatsnapMergerMatextsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeToSelect(MatsnapInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatsnapInfo> merger = new MatsnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeToSelect(List<MatsnapInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatsnapInfo> merger = new MatsnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
