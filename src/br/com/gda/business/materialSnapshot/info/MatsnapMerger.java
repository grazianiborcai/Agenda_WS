package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.info.InfoMerger;

public final class MatsnapMerger {	
	public static MatsnapInfo mergeWithMatCateg(MatCategInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger<MatsnapInfo, MatCategInfo> merger = new MatsnapMergerMatCateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatCateg(List<MatCategInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger<MatsnapInfo, MatCategInfo> merger = new MatsnapMergerMatCateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatGroup(MatGroupInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger<MatsnapInfo, MatGroupInfo> merger = new MatsnapMergerMatGroup();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatGroup(List<MatGroupInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger<MatsnapInfo, MatGroupInfo> merger = new MatsnapMergerMatGroup();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatType(MatTypeInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger<MatsnapInfo, MatTypeInfo> merger = new MatsnapMergerMatType();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatType(List<MatTypeInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger<MatsnapInfo, MatTypeInfo> merger = new MatsnapMergerMatType();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatUnit(MatUnitInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger<MatsnapInfo, MatUnitInfo> merger = new MatsnapMergerMatUnit();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatUnit(List<MatUnitInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger<MatsnapInfo, MatUnitInfo> merger = new MatsnapMergerMatUnit();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatsnapInfo mergeWithMatextsnap(MatextsnapInfo sourceOne, MatsnapInfo sourceTwo) {
		InfoMerger<MatsnapInfo, MatextsnapInfo> merger = new MatsnapMergerMatextsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatextsnap(List<MatextsnapInfo> sourceOnes, List<MatsnapInfo> sourceTwos) {
		InfoMerger<MatsnapInfo, MatextsnapInfo> merger = new MatsnapMergerMatextsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
