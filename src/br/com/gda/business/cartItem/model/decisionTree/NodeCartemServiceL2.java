package br.com.gda.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.StdCartemSuccess;
import br.com.gda.business.cartItem.model.checker.CartemCheckEmp;
import br.com.gda.business.cartItem.model.checker.CartemCheckEmpmat;
import br.com.gda.business.cartItem.model.checker.CartemCheckEmpos;
import br.com.gda.business.cartItem.model.checker.CartemCheckIsTimeAged;
import br.com.gda.business.cartItem.model.checker.CartemCheckMatore;
import br.com.gda.business.cartItem.model.checker.CartemCheckQuantity;
import br.com.gda.business.cartItem.model.checker.CartemCheckStore;
import br.com.gda.business.cartItem.model.checker.CartemCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartemServiceL2 extends DeciTreeWriteTemplate<CartemInfo> {
	
	public NodeCartemServiceL2(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartemCheckWrite();
		queue.add(checker);
		
		checker = new CartemCheckQuantity();
		queue.add(checker);
		
		checker = new CartemCheckIsTimeAged();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckMatore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckEmpos(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckEmpmat(checkerOption);
		queue.add(checker);
		
		//TODO: check emp work time
		//TODO: check store work time
		//TODO: check store leave time
		//TODO: check emp leave time
		//TODO: is valid? Pode ter mudado apos ser inserido no carrinho
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> success = new StdCartemSuccess(option);			
		actions.add(success);
		
		return actions;
	}
}
