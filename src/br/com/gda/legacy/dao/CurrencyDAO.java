package br.com.gda.legacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gda.helper.CurrencyBase;
import br.com.gda.legacy.dao.helper.CurrencyHelper;
import br.com.gda.legacy.db.ConnectionBD;

public class CurrencyDAO extends ConnectionBD {

	public CurrencyBase selectCurrency(String baseCode, String language) throws SQLException {

		CurrencyBase currencyBase = new CurrencyBase();
		Connection conn = null;
		PreparedStatement selectStmt = null;
		ResultSet resultSet = null;

		try {

			conn = getConnection();

			CurrencyHelper currencyHelper = new CurrencyHelper();

			selectStmt = conn.prepareStatement(currencyHelper.prepareSelect(language));

			resultSet = selectStmt.executeQuery();

			while (resultSet.next()) {

				currencyHelper.assignResult(currencyBase, baseCode, resultSet);

			}

			if (currencyBase.getBaseCode() == null)
				throw new SQLException();

			return currencyBase;

		} catch (SQLException e) {
			throw e;
		} finally {
			closeConnection(conn, selectStmt, resultSet);
		}
	}

}
