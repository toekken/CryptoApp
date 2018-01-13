package crypto;

import crypto.binance.BinanceHandler;
import crypto.bitgrail.BitGrailHandler;
import crypto.bitstamp.BitstampHandler;
import crypto.bittrex.BittrexHandler;
import crypto.cryptopia.CryptopiaHandler;
import crypto.gdax.GdaxHandler;
import crypto.hitbtc.HitbtcHandler;
import crypto.tidex.TidexHandler;
import crypto.utils.Frequency;
import crypto.utils.TradeItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CryptoUI
        extends JFrame {

    private static final String WORKING_DIR = System.getProperty("user.home") + File.separator + "Crypto";
    private static final String WORKING_FILE = WORKING_DIR + File.separator + "CryptoPortfolio_%s.txt";
    private static long millis = 10000L;
    private static final Map<String, List<TradeItem>> TRADES = new HashMap<String, List<TradeItem>>();
    private static boolean isStarted = false;
    private static final ScheduledExecutorService SEC = Executors.newScheduledThreadPool(5);
    private static ScheduledFuture<?> task;
    private static JLabel InvalidBaseToMarket;
    private JButton addToWatchList;
    private static JComboBox<String> baseCurrencyCombo;
    private static JLabel binanceInvestment;
    private static JLabel binanceLabel;
    private static JLabel bitGrailInvestment;
    private static JLabel bitGrailLabel;
    private static JLabel bitstampInvestment;
    private static JLabel bitstampLabel;
    private static JLabel bittrexInvestment;
    private static JLabel bittrexLabel;
    private static JLabel cryptopiaInvestment;
    private static JLabel cryptopiaLabel;
    private static JComboBox<String> currencyValue;
    private static JComboBox<String> exchangeCombo;
    private static JComboBox<String> frequency;
    private static JLabel gdaxInvestment;
    private static JLabel gdaxLabel;
    private static JLabel hitbtcInvestment;
    private static JLabel hitbtcLabel;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JTextField market;
    private static JTextField purchasePrice;
    private JTextField quantityOwnedInput;
    private JButton refresh;
    private static JLabel tidexInvestment;
    private static JLabel tidexLabel;
    private static JLabel totalPortfolioPrice;
    private static JTable watches;

    public CryptoUI() {
        this.initComponents();
    }

    private TickerHandler getHandler(String exchange, String currency, boolean convertToUSD) {
        TickerHandler handler = null;
        if (null != exchange) {
            switch (exchange) {
                case Constants.BITTREX: {
                    handler = new BittrexHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.BINANCE: {
                    handler = new BinanceHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.GDAX: {
                    handler = new GdaxHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.BITSTAMP: {
                    handler = new BitstampHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.HITBTC: {
                    handler = new HitbtcHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.BITGRAIL: {
                    handler = new BitGrailHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.TIDEX: {
                    handler = new TidexHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
                case Constants.CRYPTOPIA: {
                    handler = new CryptopiaHandler().getTicker(this.market.getText(), currency, convertToUSD);
                    break;
                }
            }
        }
        return handler;
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        watches = new JTable();
        this.jLabel1 = new JLabel();
        frequency = new JComboBox();
        exchangeCombo = new JComboBox();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.addToWatchList = new JButton();
        baseCurrencyCombo = new JComboBox();
        this.jLabel4 = new JLabel();
        this.market = new JTextField();
        InvalidBaseToMarket = new JLabel();
        this.jLabel5 = new JLabel();
        this.quantityOwnedInput = new JTextField();
        totalPortfolioPrice = new JLabel();
        this.jButton1 = new JButton();
        this.jLabel6 = new JLabel();
        purchasePrice = new JTextField();
        this.refresh = new JButton();
        gdaxLabel = new JLabel();
        bittrexLabel = new JLabel();
        binanceLabel = new JLabel();
        hitbtcLabel = new JLabel();
        bitstampLabel = new JLabel();
        gdaxInvestment = new JLabel();
        bittrexInvestment = new JLabel();
        binanceInvestment = new JLabel();
        hitbtcInvestment = new JLabel();
        bitstampInvestment = new JLabel();
        currencyValue = new JComboBox();
        bitGrailLabel = new JLabel();
        bitGrailInvestment = new JLabel();
        tidexLabel = new JLabel();
        tidexInvestment = new JLabel();
        cryptopiaLabel = new JLabel();
        cryptopiaInvestment = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.setMinimumSize(new Dimension(1700, 475));
        watches.setModel(new DefaultTableModel(new Object[0][], new String[]{"Symbol", "Base Currency", "Exchange", "Quantity Owned", "Purchase Price", "Current Price", "Initial Investment", "Gains/Losses", "% Gains/Losses", "Total Investment", "% Portfolio"}));
        this.jScrollPane1.setViewportView(watches);
        watches.setAutoCreateRowSorter(true);
        watches.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, isFocus, row, column);
                if (column == 7) {
                    if (!((String) value).isEmpty() && ((String) value).charAt(1) == '-') {
                        c.setForeground(Color.RED);
                    } else {
                        c.setForeground(Color.decode("#00611C"));
                    }
                } else if (column == 8) {
                    if (!((String) value).isEmpty() && ((String) value).charAt(0) == '-') {
                        c.setForeground(Color.RED);
                    } else {
                        c.setForeground(Color.decode("#00611C"));
                    }
                } else {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(watches.getModel());
        Comparator<String> currencyCompare = new Comparator<String>() {

            @Override
            public int compare(String first, String second) {
                Double dbl1 = Double.parseDouble(first.substring(1));
                Double dbl2 = Double.parseDouble(second.substring(1));
                return dbl2.compareTo(dbl1);
            }
        };
        Comparator<String> percentCompare = new Comparator<String>() {

            @Override
            public int compare(String first, String second) {
                Double dbl1 = Double.parseDouble(first.substring(0, first.length() - 1));
                Double dbl2 = Double.parseDouble(second.substring(0, second.length() - 1));
                return dbl2.compareTo(dbl1);
            }
        };
        sorter.setComparator(8, percentCompare);
        sorter.setComparator(10, percentCompare);
        sorter.setComparator(4, currencyCompare);
        sorter.setComparator(5, currencyCompare);
        sorter.setComparator(6, currencyCompare);
        sorter.setComparator(7, currencyCompare);
        sorter.setComparator(9, currencyCompare);
        watches.setRowSorter(sorter);
        this.jLabel1.setText("Update Frequency:");
        frequency.setModel(new DefaultComboBoxModel<String>(Frequency.getFrequencies()));
        frequency.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.frequencyActionPerformed(evt);
            }
        });
        exchangeCombo.setModel(new DefaultComboBoxModel<String>(new String[]{Constants.BINANCE, Constants.BITTREX, Constants.GDAX, Constants.HITBTC, Constants.BITGRAIL, Constants.TIDEX, Constants.CRYPTOPIA}));
        exchangeCombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.exchangeComboActionPerformed(evt);
            }
        });
        this.jLabel2.setText("Exchange:");
        this.jLabel3.setText("Market:");
        this.addToWatchList.setText("Add To Watchlist");
        this.addToWatchList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.addToWatchListActionPerformed(evt);
            }
        });
        baseCurrencyCombo.setModel(new DefaultComboBoxModel<String>(new String[]{Constants.USDT, Constants.BTC, Constants.ETH}));
        this.jLabel4.setText("Base Currency:");
        this.market.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.marketActionPerformed(evt);
            }
        });
        InvalidBaseToMarket.setFont(new Font("Tahoma", 1, 11));
        InvalidBaseToMarket.setForeground(new Color(255, 0, 0));
        InvalidBaseToMarket.setText("Invalid Base Currency to Market combination");
        this.jLabel5.setText("Quantity Owned:");
        this.quantityOwnedInput.setText("0");
        totalPortfolioPrice.setFont(new Font("Tahoma", 1, 24));
        totalPortfolioPrice.setHorizontalAlignment(0);
        totalPortfolioPrice.setText("$0.00");
        this.jButton1.setText("Remove Item(s)");
        this.jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel6.setText("Purchase Price:");
        purchasePrice.setText("0");
        this.refresh.setText("Update Cached File");
        this.refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.refreshActionPerformed(evt);
            }
        });
        gdaxLabel.setText("GDAX:");
        bittrexLabel.setText("Bittrex:");
        binanceLabel.setText("Binance:");
        hitbtcLabel.setText("HitBTC:");
        bitstampLabel.setText("Bitstamp:");
        currencyValue.setModel(new DefaultComboBoxModel<String>(new String[]{Constants.USD, Constants.SATOSHI}));
        currencyValue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                CryptoUI.this.currencyValueActionPerformed(evt);
            }
        });
        bitGrailLabel.setText("BitGrail:");
        tidexLabel.setText("Tidex:");
        cryptopiaLabel.setText("Cryptopia:");
        this.jLabel7.setText("Donation Addresses");
        this.jLabel8.setFont(new Font("Tahoma", 0, 10));
        this.jLabel8.setText("BTC: 1CSRCHfgDiThxZ33B1JziE8ayUAgxLvavJ");
        this.jLabel9.setFont(new Font("Tahoma", 0, 10));
        this.jLabel9.setText("ETH: 0x9364b215Ff6E6DDa042fB8B2E218AB40c86631D6 ");
        this.jLabel10.setFont(new Font("Tahoma", 0, 10));
        this.jLabel10.setText("LTC: Lhebh3d4m5LeeH7cizLphTwTETm9JiV8Nz ");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(baseCurrencyCombo, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel3).addGap(10, 10, 10).addComponent(this.market, -2, 74, -2)).addComponent(exchangeCombo, -2, 222, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.addToWatchList, -2, 159, -2).addGap(18, 18, 18).addComponent(InvalidBaseToMarket).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(totalPortfolioPrice, -2, 150, -2).addGap(54, 54, 54).addComponent(this.jButton1, -2, 144, -2)).addGroup(layout.createSequentialGroup().addGap(402, 402, 402).addComponent(currencyValue, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(frequency, -2, 106, -2)))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(layout.createSequentialGroup().addGap(93, 93, 93).addComponent(this.quantityOwnedInput, -2, 91, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(purchasePrice, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.refresh)))).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 1433, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(gdaxLabel, -1, -1, 32767).addComponent(bittrexLabel, -1, -1, 32767).addComponent(binanceLabel, -1, -1, 32767).addComponent(hitbtcLabel, -1, -1, 32767).addComponent(bitstampLabel, -1, 54, 32767).addComponent(bitGrailLabel, -1, -1, 32767)).addComponent(tidexLabel).addComponent(cryptopiaLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(gdaxInvestment, -1, -1, 32767).addComponent(bittrexInvestment, -1, -1, 32767).addComponent(binanceInvestment, -1, -1, 32767).addComponent(hitbtcInvestment, -1, -1, 32767).addComponent(bitstampInvestment, -1, -1, 32767).addComponent(bitGrailInvestment, -1, -1, 32767).addComponent(tidexInvestment, -1, -1, 32767).addComponent(cryptopiaInvestment, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.jLabel7).addGap(0, 0, 32767)))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10)).addGap(0, 0, 32767))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(frequency, -2, -1, -2).addComponent(this.jLabel1, -2, 28, -2)).addGap(7, 7, 7).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.refresh)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(exchangeCombo, -2, -1, -2).addComponent(this.jLabel2).addComponent(currencyValue, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(baseCurrencyCombo, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.market, -2, -1, -2).addComponent(this.addToWatchList).addComponent(InvalidBaseToMarket).addComponent(totalPortfolioPrice)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.quantityOwnedInput, -2, -1, -2).addComponent(this.jLabel6).addComponent(purchasePrice, -2, -1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 354, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(gdaxLabel, -2, 31, -2).addComponent(gdaxInvestment, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bittrexLabel, -2, 26, -2).addComponent(bittrexInvestment, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(binanceLabel, -2, 23, -2).addComponent(binanceInvestment, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(hitbtcLabel, -2, 22, -2).addComponent(hitbtcInvestment, -2, 22, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bitstampLabel, -2, 23, -2).addComponent(bitstampInvestment, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bitGrailLabel).addComponent(bitGrailInvestment, -2, 22, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(tidexLabel).addComponent(tidexInvestment, -2, 22, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(cryptopiaLabel).addComponent(cryptopiaInvestment, -2, 14, -2)).addGap(37, 37, 37).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10).addGap(0, 21, 32767)))));
        InvalidBaseToMarket.setVisible(false);
        gdaxLabel.setVisible(false);
        bittrexLabel.setVisible(false);
        binanceLabel.setVisible(false);
        hitbtcLabel.setVisible(false);
        bitstampLabel.setVisible(false);
        gdaxInvestment.setVisible(false);
        bittrexInvestment.setVisible(false);
        binanceInvestment.setVisible(false);
        hitbtcInvestment.setVisible(false);
        bitstampInvestment.setVisible(false);
        currencyValue.setSelectedIndex(0);
        this.pack();
    }

    private void exchangeComboActionPerformed(ActionEvent evt) {
    }

    private void addToWatchListActionPerformed(ActionEvent evt) {
        String currency;
        String exchange = (String) exchangeCombo.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) watches.getModel();
        InvalidBaseToMarket.setVisible(false);
        TickerHandler handler = null;
        boolean isValid = true;
        double quantity = 0.0;
        try {
            quantity = Double.parseDouble(this.quantityOwnedInput.getText());
        } catch (NumberFormatException nfe) {
            InvalidBaseToMarket.setText("Invalid quantity");
            InvalidBaseToMarket.setVisible(true);
            isValid = false;
        }
        double buyPrice = 0.0;
        try {
            buyPrice = Double.parseDouble(purchasePrice.getText());
        } catch (NumberFormatException nfe) {
            InvalidBaseToMarket.setText("Invalid Purchase Price");
            InvalidBaseToMarket.setVisible(true);
            isValid = false;
        }
        boolean satoshi = Constants.SATOSHI.equals((String) currencyValue.getSelectedItem());
        String string = currency = satoshi ? Constants.BTC : (String) baseCurrencyCombo.getSelectedItem();
        if (isValid) {
            handler = this.getHandler(exchange, currency, true);
            if (handler != null) {
                String lastPrice;
                List items;
                String key = this.market.getText() + Constants.DASH + currency + Constants.DASH + exchange;
                boolean isNewRow = true;
                if (TRADES.containsKey(key)) {
                    items = TRADES.get(key);
                    isNewRow = false;
                } else {
                    items = new ArrayList();
                }
                TradeItem item = new TradeItem();
                item.setCost(buyPrice);
                item.setQuantity(quantity);
                items.add(item);
                TRADES.put(key, items);
                String string2 = lastPrice = satoshi ? String.valueOf((int) (handler.getLastPrice() * 1.0E8)) : Constants.DOLLAR + handler.getLastPrice();
                if (isNewRow) {
                    double totalInvestment = (int) (quantity * (double) ((int) (handler.getLastPrice() * 1.0E8)));
                    double initialInvestment = (int) (quantity * buyPrice);
                    double gains = totalInvestment - initialInvestment;
                    double percentGains = gains / initialInvestment * 100.0;
                    Object[] arrobject = new String[11];
                    arrobject[0] = this.market.getText();
                    arrobject[1] = currency;
                    arrobject[2] = exchange;
                    arrobject[3] = this.quantityOwnedInput.getText();
                    arrobject[4] = Constants.DOLLAR + purchasePrice.getText();
                    arrobject[5] = lastPrice;
                    arrobject[6] = satoshi ? String.valueOf(initialInvestment) : Constants.DOLLAR + initialInvestment;
                    arrobject[7] = satoshi ? String.valueOf(gains) : Constants.DOLLAR + gains;
                    arrobject[8] = String.format("%.2f", percentGains) + Constants.PERCENT;
                    arrobject[9] = satoshi ? String.valueOf(totalInvestment) : Constants.DOLLAR + totalInvestment;
                    arrobject[10] = Constants.EMPTY_STRING;
                    model.addRow(arrobject);
                }
                CryptoUI.loadToFile();
                SwingUtilities.invokeLater(CryptoUI.monitor());
            } else {
                InvalidBaseToMarket.setText("Invalid Base Currency to Market Combination");
                InvalidBaseToMarket.setVisible(true);
            }
        }
    }

    private void frequencyActionPerformed(ActionEvent evt) {
        millis = Frequency.valueOfLabel((String) frequency.getSelectedItem()).getMillis();
        task.cancel(false);
        task = SEC.scheduleAtFixedRate(CryptoUI.monitor(), millis, millis, TimeUnit.MILLISECONDS);
    }

    private void marketActionPerformed(ActionEvent evt) {
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        int[] rows = watches.getSelectedRows();
        if (rows != null && rows.length > 0) {
            DefaultTableModel model = (DefaultTableModel) watches.getModel();
            for (int row : rows) {
                String market = (String) model.getValueAt(row, 0);
                String bc = (String) model.getValueAt(row, 1);
                String exchange = (String) model.getValueAt(row, 2);
                TRADES.remove(market + Constants.DASH + bc + Constants.DASH + exchange);
                model.removeRow(watches.convertRowIndexToModel(row));
            }
            watches.clearSelection();
        }
        CryptoUI.loadToFile();
    }

    private void refreshActionPerformed(ActionEvent evt) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, List<TradeItem>> entry : TRADES.entrySet()) {
            String[] key = entry.getKey().split(Constants.DASH);
            List<TradeItem> values = entry.getValue();
            builder.append(key[0]).append(Constants.PIPE);
            builder.append(key[1]).append(Constants.PIPE);
            builder.append(key[2]).append(Constants.PIPE);
            Iterator<TradeItem> it = values.iterator();
            while (it.hasNext()) {
                TradeItem item = it.next();
                builder.append(item.getCost()).append(Constants.UNDERSCORE).append(item.getQuantity());
                if (!it.hasNext()) {
                    continue;
                }
                builder.append(Constants.COMMA);
            }
            builder.append(System.getProperty("line.separator"));
        }
        try {
            PrintWriter pw = new PrintWriter(String.format(WORKING_FILE, (String) currencyValue.getSelectedItem()));
            try {
                pw.append(builder.toString());
            } catch (Exception ex) {
                System.err.println(ex);
                Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    pw.close();
                } catch (Exception ex) {
                    System.err.println(ex);
                    Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void currencyValueActionPerformed(ActionEvent evt) {
        if (isStarted) {
            ((DefaultTableModel) watches.getModel()).setRowCount(0);
            TRADES.clear();
            if (Constants.SATOSHI.equals(currencyValue.getSelectedItem())) {
                baseCurrencyCombo.removeAllItems();
                baseCurrencyCombo.addItem(Constants.BTC);
            } else {
                baseCurrencyCombo.removeAllItems();
                baseCurrencyCombo.addItem(Constants.USDT);
                baseCurrencyCombo.addItem(Constants.BTC);
                baseCurrencyCombo.addItem(Constants.ETH);
            }
            CryptoUI.initialLoad();
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) {
                    continue;
                }
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
            Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> {
            CryptoUI ui = new CryptoUI();
            CryptoUI.initialLoad();
            ui.setVisible(true);
        }
        );
        task = SEC.scheduleAtFixedRate(CryptoUI.monitor(), millis, millis, TimeUnit.MILLISECONDS);
    }

    private static void loadToFile() {
        File file = new File(String.format(WORKING_FILE, (String) currencyValue.getSelectedItem()));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println(ex);
                Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            PrintWriter pw = new PrintWriter(String.format(WORKING_FILE, (String) currencyValue.getSelectedItem()));
            try {
                DefaultTableModel model = (DefaultTableModel) watches.getModel();
                for (int row = 0; row < model.getRowCount(); ++row) {
                    StringBuilder builder = new StringBuilder();
                    String market = null;
                    String baseCurrency = null;
                    String exchange = null;
                    block19:
                    for (int column = 0; column < model.getColumnCount(); ++column) {
                        switch (column) {
                            case 0: {
                                market = (String) model.getValueAt(row, column);
                                builder.append(market).append(Constants.PIPE);
                                break;
                            }
                            case 1: {
                                baseCurrency = (String) model.getValueAt(row, column);
                                builder.append(baseCurrency).append(Constants.PIPE);
                                break;
                            }
                            case 2: {
                                exchange = (String) model.getValueAt(row, column);
                                builder.append(exchange).append(Constants.PIPE);
                                break;
                            }
                        }
                    }
                    List<TradeItem> items = TRADES.get(market + Constants.DASH + baseCurrency + Constants.DASH + exchange);
                    for (int count = 0; count < items.size(); ++count) {
                        if (count == items.size() - 1) {
                            builder.append(items.get(count).toString()).append(System.getProperty("line.separator"));
                            continue;
                        }
                        builder.append(items.get(count).toString()).append(Constants.COMMA);
                    }
                    pw.append(builder.toString());
                }
            } catch (Exception ex) {
                System.err.println(ex);
                Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    pw.close();
                } catch (Exception ex) {
                    System.err.println(ex);
                    Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void initialLoad() {
        File file = new File(WORKING_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        if ((file = new File(String.format(WORKING_FILE, (String) currencyValue.getSelectedItem()))).exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(String.format(WORKING_FILE, (String) currencyValue.getSelectedItem())));
                try {
                    String line = br.readLine();
                    while (line != null) {
                        String[] vals = line.split("\\|");
                        DefaultTableModel model = (DefaultTableModel) watches.getModel();
                        String[] quantPrice = vals[3].split(Constants.COMMA);
                        ArrayList<TradeItem> items = new ArrayList<TradeItem>();
                        String quantToPut = vals[3];
                        for (String qp : quantPrice) {
                            TradeItem item = new TradeItem();
                            String[] value = qp.split(Constants.UNDERSCORE);
                            if (value.length == 2) {
                                item.setCost(Double.parseDouble(value[0]));
                                item.setQuantity(Double.parseDouble(value[1]));
                                quantToPut = Constants.EMPTY_STRING;
                            } else {
                                item.setQuantity(Double.parseDouble(value[0]));
                            }
                            items.add(item);
                        }
                        TRADES.put(vals[0] + Constants.DASH + vals[1] + Constants.DASH + vals[2], items);
                        model.addRow(new String[]{vals[0], vals[1], vals[2], quantToPut, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING});
                        line = br.readLine();
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                    Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        br.close();
                    } catch (Exception ex) {
                        System.err.println(ex);
                        Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                System.err.println(ex);
                Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println(ex);
                Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        SwingUtilities.invokeLater(CryptoUI.monitor());
        isStarted = true;
    }

    private static Runnable monitor() {
        return () -> {
            try {
                int row;
                boolean satoshi = Constants.SATOSHI.equals((String) currencyValue.getSelectedItem());
                InvalidBaseToMarket.setVisible(false);
                DefaultTableModel model = (DefaultTableModel) watches.getModel();
                double totalInvestment = 0.0;
                HashMap<String, Double> portfolio = new HashMap<String, Double>();
                HashMap<String, Double> exchangePrices = new HashMap<String, Double>();
                exchangePrices.put(Constants.BITTREX, 0.0);
                exchangePrices.put(Constants.BINANCE, 0.0);
                exchangePrices.put(Constants.GDAX, 0.0);
                exchangePrices.put(Constants.BITSTAMP, 0.0);
                exchangePrices.put(Constants.HITBTC, 0.0);
                exchangePrices.put(Constants.BITGRAIL, 0.0);
                exchangePrices.put(Constants.TIDEX, 0.0);
                exchangePrices.put(Constants.CRYPTOPIA, 0.0);
                HashMap<String, Double> btcPrices = new HashMap<String, Double>();
                btcPrices.put(Constants.BITTREX, 1.0);
                btcPrices.put(Constants.BINANCE, 1.0);
                btcPrices.put(Constants.GDAX, 1.0);
                btcPrices.put(Constants.BITSTAMP, 1.0);
                btcPrices.put(Constants.HITBTC, 1.0);
                btcPrices.put(Constants.BITGRAIL, 1.0);
                btcPrices.put(Constants.TIDEX, 1.0);
                btcPrices.put(Constants.CRYPTOPIA, 1.0);
                for (row = 0; row < model.getRowCount(); ++row) {
                    TickerHandler handler = null;
                    TickerHandler btcHandler = null;
                    String market = null;
                    String baseCurrency = null;
                    String exchange = null;
                    String avgPurchasePrice = null;
                    double quantitySum = 0.0;
                    double priceSum = 0.0;
                    double currentInvestment = 0.0;
                    for (int column = 0; column < model.getColumnCount(); ++column) {
                        switch (column) {
                            case 0: {
                                market = (String) model.getValueAt(row, column);
                                break;
                            }
                            case 1: {
                                baseCurrency = (String) model.getValueAt(row, column);
                                break;
                            }
                            case 2: {
                                exchange = (String) model.getValueAt(row, column);
                                break;
                            }
                            case 3: {
                                String key = market + Constants.DASH + baseCurrency + Constants.DASH + exchange;
                                List<TradeItem> items = TRADES.get(key);
                                if (items != null) {
                                    Iterator<TradeItem> iterator = items.iterator();
                                    while (iterator.hasNext()) {
                                        TradeItem item = (TradeItem) iterator.next();
                                        quantitySum += item.getQuantity();
                                        priceSum += item.getQuantity() * item.getCost();
                                    }
                                }
                                model.setValueAt(String.valueOf(quantitySum), row, column);
                                break;
                            }
                            case 4: {
                                avgPurchasePrice = satoshi ? String.valueOf((int) (priceSum / quantitySum)) : String.valueOf(priceSum / quantitySum);
                                model.setValueAt((satoshi ? Constants.EMPTY_STRING : Constants.DOLLAR) + avgPurchasePrice, row, column);
                                break;
                            }
                            case 5: {
                                if (null != exchange) {
                                    switch (exchange) {
                                        case Constants.BITTREX: {
                                            handler = new BittrexHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new BittrexHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.BINANCE: {
                                            handler = new BinanceHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new BinanceHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.GDAX: {
                                            handler = new GdaxHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new GdaxHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.BITSTAMP: {
                                            handler = new BitstampHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new BitstampHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.HITBTC: {
                                            handler = new HitbtcHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new HitbtcHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.BITGRAIL: {
                                            handler = new BitGrailHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new BitGrailHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.TIDEX: {
                                            handler = new TidexHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new TidexHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                        case Constants.CRYPTOPIA: {
                                            handler = new CryptopiaHandler().getTicker(market, satoshi ? Constants.BTC : baseCurrency, !satoshi);
                                            if (!satoshi) {
                                                break;
                                            }
                                            btcHandler = new CryptopiaHandler().getTicker(Constants.BTC, Constants.USDT, false);
                                            break;
                                        }
                                    }
                                }
                                if (handler != null) {
                                    String current = Constants.DOLLAR + handler.getLastPrice();
                                    if (satoshi) {
                                        current = String.valueOf((int) (handler.getLastPrice() * 1.0E8));
                                    }
                                    model.setValueAt(current, row, column);
                                }
                                if (btcHandler == null) {
                                    break;
                                }
                                btcPrices.put(exchange, btcHandler.getLastPrice());
                                break;
                            }
                            case 6: {
                                String initialInvestment = Constants.DOLLAR + Double.parseDouble(avgPurchasePrice) * quantitySum;
                                if (satoshi) {
                                    initialInvestment = String.valueOf((int) (Double.parseDouble(avgPurchasePrice) * quantitySum));
                                }
                                model.setValueAt(initialInvestment, row, column);
                                break;
                            }
                            case 7: {
                                if (handler == null) {
                                    break;
                                }
                                String gains = Constants.DOLLAR + (handler.getLastPrice() * quantitySum - Double.parseDouble(avgPurchasePrice) * quantitySum);
                                if (satoshi) {
                                    gains = String.valueOf((int) ((double) ((int) (handler.getLastPrice() * 1.0E8)) * quantitySum) - (int) (Double.parseDouble(avgPurchasePrice) * quantitySum));
                                }
                                model.setValueAt(gains, row, column);
                                break;
                            }
                            case 8: {
                                if (handler == null) {
                                    break;
                                }
                                double gains = handler.getLastPrice() * quantitySum - Double.parseDouble(avgPurchasePrice) * quantitySum;
                                if (satoshi) {
                                    gains = (int) ((double) ((int) (handler.getLastPrice() * 1.0E8)) * quantitySum - Double.parseDouble(avgPurchasePrice) * quantitySum);
                                }
                                double initInvest = Double.parseDouble(avgPurchasePrice) * quantitySum;
                                model.setValueAt(String.format("%.2f%s", gains / initInvest * 100.0, Constants.PERCENT), row, column);
                                break;
                            }
                            case 9: {
                                if (handler == null) {
                                    break;
                                }
                                currentInvestment = handler.getLastPrice() * quantitySum;
                                if (satoshi) {
                                    currentInvestment = (int) ((double) ((int) (handler.getLastPrice() * 1.0E8)) * quantitySum);
                                }
                                String val = satoshi ? String.valueOf((int) currentInvestment) : Constants.DOLLAR + currentInvestment;
                                model.setValueAt(val, row, column);
                                break;
                            }
                            case 10: {
                                if (handler != null) {
                                    totalInvestment += currentInvestment;
                                    portfolio.put(market + Constants.DASH + baseCurrency + Constants.DASH + exchange, currentInvestment);
                                }
                                if (null == exchange) {
                                    break;
                                }
                                Double value = exchangePrices.containsKey(exchange) ? Double.valueOf((Double) exchangePrices.get(exchange) + currentInvestment) : Double.valueOf(currentInvestment);
                                exchangePrices.put(exchange, value);
                                break;
                            }
                        }
                    }
                }
                for (row = 0; row < model.getRowCount(); ++row) {
                    Double currentInvestment = (Double) portfolio.get((String) model.getValueAt(row, 0) + Constants.DASH + (String) model.getValueAt(row, 1) + Constants.DASH + (String) model.getValueAt(row, 2));
                    if (totalInvestment > 0.0) {
                        model.setValueAt(String.format("%.2f%s", currentInvestment / totalInvestment * 100.0, Constants.PERCENT), row, 10);
                        continue;
                    }
                    model.setValueAt(String.format("%.2f%s", 0.0, Constants.PERCENT), row, 10);
                }
                totalPortfolioPrice.setText(satoshi ? String.valueOf((int) totalInvestment) : String.format("$%.2f", totalInvestment));
                for (Map.Entry entry : exchangePrices.entrySet()) {
                    Double value = (Double) entry.getValue();
                    Double btcValue;
                    switch ((String) entry.getKey()) {
                        case Constants.BITTREX: {
                            if (value == 0.0) {
                                bittrexLabel.setVisible(false);
                                bittrexInvestment.setVisible(false);
                                break;
                            }
                            bittrexLabel.setVisible(true);
                            bittrexInvestment.setVisible(true);
                            if (satoshi) {
                                bittrexInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            bittrexInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.BINANCE: {
                            if (value == 0.0) {
                                binanceLabel.setVisible(false);
                                binanceInvestment.setVisible(false);
                                break;
                            }
                            binanceLabel.setVisible(true);
                            binanceInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.BINANCE);
                                binanceInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            binanceInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.GDAX: {
                            if (value == 0.0) {
                                gdaxLabel.setVisible(false);
                                gdaxInvestment.setVisible(false);
                                break;
                            }
                            gdaxLabel.setVisible(true);
                            gdaxInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.GDAX);
                                gdaxInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            gdaxInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.BITSTAMP: {
                            if (value == 0.0) {
                                bitstampLabel.setVisible(false);
                                bitstampInvestment.setVisible(false);
                                break;
                            }
                            bitstampLabel.setVisible(true);
                            bitstampInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.BITSTAMP);
                                bitstampInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            bitstampInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.HITBTC: {
                            if (value == 0.0) {
                                hitbtcLabel.setVisible(false);
                                hitbtcInvestment.setVisible(false);
                                break;
                            }
                            hitbtcLabel.setVisible(true);
                            hitbtcInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.HITBTC);
                                hitbtcInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            hitbtcInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.BITGRAIL: {
                            if (value == 0.0) {
                                bitGrailLabel.setVisible(false);
                                bitGrailInvestment.setVisible(false);
                                break;
                            }
                            bitGrailLabel.setVisible(true);
                            bitGrailInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.BITGRAIL);
                                bitGrailInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            bitGrailInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.TIDEX: {
                            if (value == 0.0) {
                                tidexLabel.setVisible(false);
                                tidexInvestment.setVisible(false);
                                break;
                            }
                            tidexLabel.setVisible(true);
                            tidexInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.TIDEX);
                                tidexInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            tidexInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                        case Constants.CRYPTOPIA: {
                            if (value == 0.0) {
                                cryptopiaLabel.setVisible(false);
                                cryptopiaInvestment.setVisible(false);
                                break;
                            }
                            cryptopiaLabel.setVisible(true);
                            cryptopiaInvestment.setVisible(true);
                            if (satoshi) {
                                btcValue = (Double) btcPrices.get(Constants.CRYPTOPIA);
                                cryptopiaInvestment.setText(String.format("%d", value.intValue()));
                                break;
                            }
                            cryptopiaInvestment.setText(String.format("$%.2f", value));
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                System.err.println(ex);
                Logger.getLogger(CryptoUI.class.getName()).log(Level.SEVERE, null, ex);
                InvalidBaseToMarket.setText("Error occurred while gathering latest data.");
                InvalidBaseToMarket.setVisible(true);
            }
        };
    }

}
