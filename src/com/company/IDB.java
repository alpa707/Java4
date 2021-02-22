package com.company.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * The interface of IDB and connection with postgre
 *
 */
public interface IDB
{
    Connection getConnection() throws SQLException, ClassNotFoundException;
}

