package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatMerger {
	public static MatInfo mergeWithFimist(FimistInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, FimistInfo> merger = new MatMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, FimistInfo> merger = new MatMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithMatCateg(MatCategInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatCategInfo> merger = new MatMergerMatCateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithMatCateg(List<MatCategInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatCategInfo> merger = new MatMergerMatCateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithMatext(MatextInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatextInfo> merger = new MatMergerMatext();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithMatext(List<MatextInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatextInfo> merger = new MatMergerMatext();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithMatType(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatTypeInfo> merger = new MatMergerMatType();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithMatType(List<MatTypeInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatTypeInfo> merger = new MatMergerMatType();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithMatGroup(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatGroupInfo> merger = new MatMergerMatGroup();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithMatGroup(List<MatGroupInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatGroupInfo> merger = new MatMergerMatGroup();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithMatUnit(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatUnitInfo> merger = new MatMergerMatUnit();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithMatUnit(List<MatUnitInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatUnitInfo> merger = new MatMergerMatUnit();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithMatsnap(MatsnapInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatsnapInfo> merger = new MatMergerMatsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithMatsnap(List<MatsnapInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatsnapInfo> merger = new MatMergerMatsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeWithUsername(UsernameInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, UsernameInfo> merger = new MatMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, UsernameInfo> merger = new MatMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeToSelect(MatInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatInfo> merger = new MatMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeToSelect(List<MatInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatInfo> merger = new MatMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeToDelete(MatInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatInfo> merger = new MatMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeToDelete(List<MatInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatInfo> merger = new MatMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatInfo mergeToUpdate(MatInfo sourceOne, MatInfo sourceTwo) {
		InfoMerger_<MatInfo, MatInfo> merger = new MatMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatInfo> mergeToUpdate(List<MatInfo> sourceOnes, List<MatInfo> sourceTwos) {
		InfoMerger_<MatInfo, MatInfo> merger = new MatMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
