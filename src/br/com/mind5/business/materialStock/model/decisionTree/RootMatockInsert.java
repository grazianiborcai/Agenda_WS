package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.LazyMatockInsert;
import br.com.mind5.business.materialStock.model.action.LazyMatockNodeBalanceL1;
import br.com.mind5.business.materialStock.model.action.StdMatockEnforceLChanged;
import br.com.mind5.business.materialStock.model.checker.MatockCheckLangu;
import br.com.mind5.business.materialStock.model.checker.MatockCheckMat;
import br.com.mind5.business.materialStock.model.checker.MatockCheckMatmovType;
import br.com.mind5.business.materialStock.model.checker.MatockCheckOwner;
import br.com.mind5.business.materialStock.model.checker.MatockCheckStorauth;
import br.com.mind5.business.materialStock.model.checker.MatockCheckStore;
import br.com.mind5.business.materialStock.model.checker.MatockCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatockInsert extends DeciTreeWriteTemplate<MatockInfo> {
	
	public RootMatockInsert(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatockInfo> buildDecisionCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatockCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckMatmovType(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckStorauth(checkerOption);
		queue.add(checker);	
		//TODO: verificar categoria material - somente Produto
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();

		ActionStd<MatockInfo> enforceLChanged = new StdMatockEnforceLChanged(option);
		ActionLazy<MatockInfo> balance = new LazyMatockNodeBalanceL1(option.conn, option.schemaName);
		ActionLazy<MatockInfo> insert = new LazyMatockInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(balance);
		balance.addPostAction(insert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
