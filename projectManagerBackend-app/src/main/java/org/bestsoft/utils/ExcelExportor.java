package org.bestsoft.utils;

import org.springframework.stereotype.Component;

@Component
public class ExcelExportor {
    private final static String LINKTEXT = "#link#";

   /* @Value("${file.download.path}")
    private String path;

    public HSSFWorkbook exportXls(List<ProjectDto> list, String filename, Map projectMap, Map inoutcomeMap) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        if (list.size() == 0 || list.isEmpty()) {
            return hssfWorkbook;
        }
        HSSFSheet sheet = hssfWorkbook.createSheet(filename);

        CellStyle styleHead = getColumnTopStyle(hssfWorkbook);
        CellStyle stylebody = getStyle(hssfWorkbook);

        // 列标题行
        HSSFRow headRow = sheet.createRow(0);
        int colCnt = 0;
        for (Object key : projectMap.keySet()) {
            Cell cell = headRow.createCell(colCnt);
            cell.setCellValue((String) key);
            cell.setCellStyle(styleHead);
            sheet.setColumnWidth(colCnt, 20 * 256);
            colCnt++;
        }

        List<Sheet> sheets = new ArrayList<>();
        for (ProjectDto project : list) {
            HSSFSheet temp = hssfWorkbook.createSheet(String.valueOf(project.getId()));
            HSSFRow inoutcomeheadRow = temp.createRow(0);
            int tempColCnt = 0;
            for (Object inoutcomeKey : inoutcomeMap.keySet()) {
                Cell inoutcomeCell = inoutcomeheadRow.createCell(tempColCnt);
                inoutcomeCell.setCellValue((String) inoutcomeKey);
                inoutcomeCell.setCellStyle(styleHead);
                temp.setColumnWidth(tempColCnt, 20 * 256);
                tempColCnt++;
            }
            sheets.add(temp);
        }

        for (ProjectDto project : list) {
            Row dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            int colDataCnt = 0;
            for (Object value : projectMap.values()) {
                Cell cell = dataRow.createCell(colDataCnt++);
                if (value.equals("Id")) {
                    // 超链接
                    cell.setCellStyle(getLinkStyle(hssfWorkbook));
                    CreationHelper createHelper = hssfWorkbook.getCreationHelper();
                    Hyperlink hyperlink1 = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
                    cell.setHyperlink(hyperlink1);
                    hyperlink1.setAddress("#" + project.getId() + "!A1");
                    Sheet temp = sheets.get(0);
                    for (Inoutcome inoutcome : project.getInoutcomeList()) {
                        Row inoutcomeDataRow = temp.createRow(sheet.getLastRowNum() + 1);
                        int tempColCnt = 0;
                        for (Object inoutcomeValue : inoutcomeMap.values()) {
                            Cell inoutcomeCell = inoutcomeDataRow.createCell(tempColCnt++);
                            inoutcomeCell.setCellValue(readAttributeValue(inoutcome, (String) inoutcomeValue));
                            inoutcomeCell.setCellStyle(stylebody);
                        }
                    }
                }
                cell.setCellValue(readAttributeValue(project, (String) value));
                cell.setCellStyle(stylebody);
            }
        }
        return hssfWorkbook;
    }


    public CellStyle getColumnTopStyle(Workbook workbook) {

        // 设置字体
        Font font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);
        // 字体加粗
        font.setBold(true);
        // 设置字体名字
        font.setFontName("Courier New");

        // int length = str.getBytes().length;
        // sheet.setColumnWidth((short)1,(short)(length*256));
        // 设置样式;
        CellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        // 设置底边框颜色;
        // style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        // 设置左边框颜色;
        // style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;

        style.setBorderRight(BorderStyle.THIN); // 设置右边框颜色;
        // style.setRightBorderColor(HSSFColor.BLACK.index); //设置顶边框;
        style.setBorderTop(BorderStyle.THIN); // 设置顶边框颜色;
        // style.setTopBorderColor(HSSFColor.BLACK.index);

        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(true);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;

    }

    *//*
     * 列数据信息单元格样式
     *//*
    public CellStyle getStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 字体加粗
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        CellStyle style = workbook.createCellStyle();

        // 设置底边框;
        style.setBorderBottom(BorderStyle.THIN); // 设置底边框颜色;
        // style.setBottomBorderColor(HSSFColor.BLACK.index); //设置左边框;
        style.setBorderLeft(BorderStyle.THIN); // 设置左边框颜色;
        // style.setLeftBorderColor(HSSFColor.BLACK.index); //设置右边框;
        style.setBorderRight(BorderStyle.THIN); // 设置右边框颜色;
        // style.setRightBorderColor(HSSFColor.BLACK.index); //设置顶边框;
        style.setBorderTop(BorderStyle.THIN); // 设置顶边框颜色;
        // style.setTopBorderColor(HSSFColor.BLACK.index);

        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(true);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;

    }

    public CellStyle getLinkStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 字体加粗
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        font.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        // 设置样式;
        CellStyle style = workbook.createCellStyle();

        // 设置底边框;
        style.setBorderBottom(BorderStyle.THIN); // 设置底边框颜色;
        // style.setBottomBorderColor(HSSFColor.BLACK.index); //设置左边框;
        style.setBorderLeft(BorderStyle.THIN); // 设置左边框颜色;
        // style.setLeftBorderColor(HSSFColor.BLACK.index); //设置右边框;
        style.setBorderRight(BorderStyle.THIN); // 设置右边框颜色;
        // style.setRightBorderColor(HSSFColor.BLACK.index); //设置顶边框;
        style.setBorderTop(BorderStyle.THIN); // 设置顶边框颜色;
        // style.setTopBorderColor(HSSFColor.BLACK.index);

        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(true);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;
    }

    public static String readAttributeValue(Object source, String attrs) {
        Object result = source;
        for (String attr : attrs.split("\\.")) {
            Class cls = result.getClass();
            try {
                Method method = cls.getMethod("get" + attr);
                result = method.invoke(result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }*/
}
