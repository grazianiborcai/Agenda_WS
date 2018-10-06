package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerEmp extends InfoMerger<OrderInfo, EmpInfo, OrderInfo> {
	public OrderInfo merge(EmpInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorEmp());
	}
	
	
	
	public List<OrderInfo> merge(List<EmpInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorEmp());
	}
}
