package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerMat extends InfoMerger<OrderInfo, MatInfo, OrderInfo> {
	public OrderInfo merge(MatInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorMat());
	}
	
	
	
	public List<OrderInfo> merge(List<MatInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorMat());
	}
}
