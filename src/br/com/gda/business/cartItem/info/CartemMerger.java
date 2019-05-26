package br.com.gda.business.cartItem.info;

import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CartemMerger {
	public static CartemInfo mergeWithCurrency(CurrencyInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, CurrencyInfo> merger = new CartemMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, CurrencyInfo> merger = new CartemMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartemInfo mergeWithFeeDefault(FeeDefaultInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, FeeDefaultInfo> merger = new CartemMergerFeeDefault();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithFeeDefault(List<FeeDefaultInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, FeeDefaultInfo> merger = new CartemMergerFeeDefault();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithFeetore(FeetoreInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, FeetoreInfo> merger = new CartemMergerFeetore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithFeetore(List<FeetoreInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, FeetoreInfo> merger = new CartemMergerFeetore();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
	
	
	
	public static CartemInfo mergeWithMat(MatInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, MatInfo> merger = new CartemMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithMat(List<MatInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, MatInfo> merger = new CartemMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithStolis(StolisInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, StolisInfo> merger = new CartemMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, EmplisInfo> merger = new CartemMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithEmplis(EmplisInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, EmplisInfo> merger = new CartemMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, StolisInfo> merger = new CartemMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartemInfo mergeWithTotAmount(TotAmountInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, TotAmountInfo> merger = new CartemMergerTotAmount();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithTotAmount(List<TotAmountInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, TotAmountInfo> merger = new CartemMergerTotAmount();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartemInfo mergeWithUser(UserInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, UserInfo> merger = new CartemMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithUser(List<UserInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, UserInfo> merger = new CartemMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithUsername(UsernameInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, UsernameInfo> merger = new CartemMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, UsernameInfo> merger = new CartemMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithWeekday(WeekdayInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, WeekdayInfo> merger = new CartemMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, WeekdayInfo> merger = new CartemMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeToUpdate(CartemInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeToUpdate(List<CartemInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeToSelect(CartemInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeToSelect(List<CartemInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
