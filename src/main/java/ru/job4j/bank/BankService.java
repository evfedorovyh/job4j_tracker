package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса.
 * Сервис обеспечивает хранение и редактирование информации о клиентах
 * и их счетах и выполнение переводов между счетами.
 * @author EVGENY FEDOROVYH
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о клиентах (User) и их счетах (List<Account>)
     * осуществляется в коллекции типа HasMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента (User) и, если такого клиента
     * в коллекции нет, добавляет его. Идентификация клиента происходит
     * по номеру паспорта.
     * @param user клиент, которого добавляем в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта клиента и, если
     * в коллекции есть клиент с данным номером паспорта,
     * удаляет его.
     * @param passport номер паспорта клиента, которого удаляем из коллекции.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход номер паспорта клиента и данные счета,
     * по номеру паспорта идентифицирует клиента и привязывает к нему данные счета,
     * если счета с такими реквизитами у клиента еще нет.
     * @param passport номер паспорта клиента.
     * @param account новые данные счета клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта клиента.
     * Метод проверяет, есть ли в коллекции клиент с данным номером паспорта,
     * и если есть, то возвращает его.
     * @param passport номер паспорта клиента.
     * @return возвращает клиента с текущим номером паспорта.
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход номер паспорта клиента и реквизиты счета.
     * Если есть клиент с таким номером паспорта, и у него есть счет с такими реквизитами,
     * то метод возвращает данные счета.
     * @param passport номер паспорта клиента.
     * @param requisite реквизиты счета.
     * @return возвращает данные счета. В противном случае - NULL.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход номер паспорта, реквизиты счета клиента,
     * с которого планируется выполнить перевод,
     * также номер паспорта и реквизиты счета клиента,
     * которому планируется выполнить перевод, и сумму перевода.
     * Метод выполняет денежный перевод со счета на счет.
     * @param sourcePassport номер паспорта клиента, со счета которого выполняет перевод.
     * @param sourceRequisite номер счета, с которого выполняется перевод.
     * @param destinationPassport номер паспорта клиента, на счет которого осуществляется перевод.
     * @param destinationRequisite номер счета на который осуществляется перевод.
     * @param amount сумма перевода.
     * @return возвращает TRUE, если перевод выполнен. В противном случае - FALSE.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null
                && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод принимает на вход клиента и возвращает список всех счетов, привязанных к клиенту.
     * @param user текущий клиент.
     * @return возвращает список всех счетов клиента в виде списка ArrayList<Account>.
     * Если привязанных счетов нет, возвращает NULL.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
