package com.example.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.model.Countplates;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;



public class UserPDFExporter {
    private List<Countplates> listHistory;

    public UserPDFExporter(List<Countplates> listHistory) {
        this.listHistory = listHistory;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Studentid", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Breakfast", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Lunch", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Dinner", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Countplates his : listHistory) {
            table.addCell(String.valueOf(his.getStudentid()));
            table.addCell(his.getDate().toString());
            table.addCell(his.getBreakfast().toString());
            table.addCell(his.getLunch().toString());
            table.addCell(his.getDinner().toString());

        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of History", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}