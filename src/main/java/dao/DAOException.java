/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author peani371
 */
public class DAOException extends RuntimeException {

    /**
     * Creates a new instance of <code>DAOException</code> without detail
     * message.
     */
    public DAOException() {
    }

    public DAOException(String msg) {
        super(msg);
    }
    
    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
