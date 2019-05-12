package br.com.gda.business.planingData.info;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.info.InfoPruner;

public final class PlanataPruner {
	public static List<PlanataInfo> pruneWithEmplevate(List<PlanataInfo> sourceOne, List<EmplevateInfo> sourceTwo) {
		InfoPruner<PlanataInfo, EmplevateInfo> pruner = new PlanataPrunerEmplevate();		
		return pruner.prune(sourceOne, sourceTwo);
	}
}
