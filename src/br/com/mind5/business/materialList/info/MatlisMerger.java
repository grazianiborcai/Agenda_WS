package br.com.mind5.business.materialList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatlisMerger {
	public static MatlisInfo mergeWithMatMatarch(MatarchInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatarchInfo> merger = new MatlisMergerMatarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatarch(List<MatarchInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatarchInfo> merger = new MatlisMergerMatarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatlisInfo mergeWithMatCateg(MatCategInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatCategInfo> merger = new MatlisMergerMatCateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatCateg(List<MatCategInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatCategInfo> merger = new MatlisMergerMatCateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static MatlisInfo mergeWithMatext(MatextInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatextInfo> merger = new MatlisMergerMatext();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatext(List<MatextInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatextInfo> merger = new MatlisMergerMatext();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatlisInfo mergeWithMatType(MatTypeInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatTypeInfo> merger = new MatlisMergerMatType();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatType(List<MatTypeInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatTypeInfo> merger = new MatlisMergerMatType();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatlisInfo mergeWithMatGroup(MatGroupInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatGroupInfo> merger = new MatlisMergerMatGroup();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatGroup(List<MatGroupInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatGroupInfo> merger = new MatlisMergerMatGroup();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatlisInfo mergeWithMatUnit(MatUnitInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatUnitInfo> merger = new MatlisMergerMatUnit();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatUnit(List<MatUnitInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatUnitInfo> merger = new MatlisMergerMatUnit();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatlisInfo mergeToSelect(MatlisInfo sourceOne, MatlisInfo sourceTwo) {
		InfoMerger_<MatlisInfo, MatlisInfo> merger = new MatlisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatlisInfo> mergeToSelect(List<MatlisInfo> sourceOnes, List<MatlisInfo> sourceTwos) {
		InfoMerger_<MatlisInfo, MatlisInfo> merger = new MatlisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
