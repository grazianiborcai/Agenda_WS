package br.com.mind5.business.materialSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class MatsnapMerger {	
	public static MatsnapInfo mergeWithMateg(MategInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MategInfo> merger = new MatsnapMergerMateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMateg(List<MategInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MategInfo> merger = new MatsnapMergerMateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatoup(MatoupInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatoupInfo> merger = new MatsnapMergerMatoup();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatoup(List<MatoupInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatoupInfo> merger = new MatsnapMergerMatoup();		
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
	
	
	
	public static MatsnapInfo mergeWithMatunit(MatunitInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger_<MatsnapInfo, MatunitInfo> merger = new MatsnapMergerMatunit();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatunit(List<MatunitInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger_<MatsnapInfo, MatunitInfo> merger = new MatsnapMergerMatunit();		
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
